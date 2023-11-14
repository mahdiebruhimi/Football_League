import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the maximum number of teams(Enter 0 for the default number (20 teams)):");
        int maxTeamNumber = input.nextInt();
        if (maxTeamNumber == 0){
            maxTeamNumber = 20;
        }

        System.out.println("Enter the maximum number of players per team(Enter 0 for the default number (23 players)):");
        int maxPlayerTeam = input.nextInt();
        if (maxPlayerTeam == 0){
            maxPlayerTeam = 23;
        }

        int maxPlayerNumber = maxTeamNumber * maxPlayerTeam;

        System.out.println("The start of the league with a maximum of " + maxTeamNumber + " teams and a maximum of " + maxPlayerTeam + " players for each team");
        System.out.println();

        System.out.println("Select your Item:" + "\nnew \nbuy \nsell \nstatus \nmatch \nrank \nend");
        String item = input.next(); // Go to line 90
        System.out.println();

        Player player = new Player();
        Team team = new Team();
        Buy buy = new Buy();
        Sell sell = new Sell();
        Match match = new Match();
        Rank rank = new Rank();
        Status status = new Status();

        int[] idList = new int[maxPlayerNumber];
        for (int i=0; i<maxPlayerNumber; i++){
            idList[i] = i + 1;
        }

        int playerCounter = 0;
        String[] playerName = new String[maxPlayerNumber];
        int[][] playerDetail = new int[maxPlayerNumber][4]; // Go to line 101

        int teamCounter = 0;
        String[] teamName = new String[maxTeamNumber];
        int[][] teamDetail = new int[maxTeamNumber][3]; // Go to line 112

        int matchCounter = 0;

        int[][] teamPlayer = new int[maxTeamNumber][maxPlayerTeam];
        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<maxPlayerTeam; j++){
                teamPlayer[i][j] = 0;
            }
        }

        int playerBuyNumber = 0;
        int teamBuyNumber = 0;

        int playerSellNumber = 0;
        int teamSellNumber = 0;

        int[][] matchLists = new int[maxTeamNumber][5];
        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<5; j++){
                matchLists[i][j] = 0;
            }
        }

        int[][] rankLists = new int[maxTeamNumber][5];
        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<5; j++){
                rankLists[i][j] = 0;
            }
        }

        int[][] teamMatch = new int[maxTeamNumber][maxTeamNumber - 1];
        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<maxTeamNumber - 1; j++){
                teamMatch[i][j] = 0;
            }
        }

        int finishMatchs = 0;

        int team1Number = 0;
        int team2Number = 0;

        String endItem = "end";
        boolean flag = true;
        if (item.equals(endItem)){
            flag = false;
        }

        while (flag) {
            if (item.equals("new")){
                    System.out.println("Select your Item:" + "\nplayer \nteam");
                    System.out.println();
                    String item2 = input.next();
                    if (item2.equals("player")){
                        System.out.println("Create new player");
                        player.playerNameFunction(playerName, playerCounter);
                        player.playerDetailFunction(playerDetail, playerCounter);
                        System.out.println("Player successfully created.");
                        System.out.println();
                        System.out.println("The list of created players:");
                        player.playerDisplay(idList, playerName, playerDetail, playerCounter);
                        System.out.println();
                        playerCounter++;
                    }
                    else if (item2.equals("team")) {
                        System.out.println("Create new team");
                        boolean checkTeam = team.teamNameFunction(teamName, teamCounter);
                        if (checkTeam){
                            team.teamDetailFunction(teamDetail, teamCounter);
                            System.out.println("Team successfully created.");
                            System.out.println();
                            System.out.println("The created team list:");
                            team.teamDisplay(idList, teamName, teamDetail, teamCounter);
                            System.out.println();
                            teamCounter++;
                            matchLists[teamCounter - 1][0] = teamCounter;
                        }
                    }
                    else {
                        System.out.println("The entry is not correct.");
                    }
                }
                else {
                    switch (item){
                        case "buy":
                            System.out.println("Buy player");
                            System.out.println("Enter your player ID to buy:");
                            playerBuyNumber = input.nextInt();
                            System.out.println("Enter your team ID to buy player:");
                            teamBuyNumber = input.nextInt();
                            boolean checkBuy = buy.checkBuyFunction(teamPlayer, maxTeamNumber, maxPlayerTeam, playerDetail, teamDetail, playerBuyNumber, teamBuyNumber, playerCounter, teamCounter);
                            if (checkBuy){
                                teamDetail[teamBuyNumber - 1][0] -= playerDetail[playerBuyNumber - 1][0];
                                teamDetail[teamBuyNumber - 1][1] += playerDetail[playerBuyNumber - 1][0];
                                boolean checkAdd = buy.addPlayerFunction(teamPlayer, teamBuyNumber, playerBuyNumber, maxPlayerTeam);
                                if (checkAdd){
                                    teamDetail[teamBuyNumber - 1][2] ++;
                                    System.out.println("Player with ID of " + playerBuyNumber + " for team with ID of " + teamBuyNumber + " successfully bought.");
                                    System.out.println();
                                    System.out.println("List of every team players after adding player:");
                                    buy.teamPlayerDisplayFunction(teamName, idList, teamPlayer, maxTeamNumber, maxPlayerTeam);
                                }
                            }
                            break;

                        case "sell":
                            System.out.println("Sell player");
                            System.out.println("Enter your player ID to sell:");
                            playerSellNumber = input.nextInt();
                            System.out.println("Enter your team ID to sell player:");
                            teamSellNumber = input.nextInt();
                            boolean checkSell = sell.checkSellFunction(teamPlayer, maxPlayerTeam, playerSellNumber, teamSellNumber, teamCounter);
                            if (checkSell){
                                teamDetail[teamSellNumber - 1][0] += playerDetail[playerSellNumber - 1][0];
                                teamDetail[teamSellNumber - 1][1] -= playerDetail[playerSellNumber - 1][0];
                                sell.removePlayer(teamPlayer, maxPlayerTeam, playerSellNumber, teamSellNumber);
                                teamDetail[teamSellNumber - 1][2] --;
                                System.out.println("Player with ID of " + playerSellNumber + " of team with ID of " + teamSellNumber + " sold successfully!.");
                                System.out.println();
                                System.out.println("List of every team players after removing player:");
                                sell.teamPlayerDisplayFunction(teamName, idList, teamPlayer, maxTeamNumber, maxPlayerTeam);
                            }
                            break;

                        case "status":
                            if (teamCounter > 0){
                                status.teamsStatus(teamName, teamDetail, teamCounter);
                            }
                            else {
                                System.out.println("A team has not been created yet.");
                            }
                            break;

                        case "match":
                            System.out.println("Play game");
                            System.out.println("Enter host's ID:");
                            team1Number = input.nextInt();
                            System.out.println("Enter guest's ID:");
                            team2Number = input.nextInt();
                            boolean checkMatch = match.checkMatch(teamMatch, teamPlayer, maxPlayerTeam, team1Number, team2Number, teamCounter);
                            if (checkMatch){
                                matchCounter ++;

                                for (int i=1; i<=teamCounter-1; i++){
                                    finishMatchs += i;
                                }

                                match.teamMatchFunction(teamMatch, maxTeamNumber, team1Number, team2Number);
                                match.resultMatch(teamName, teamDetail, matchLists, rankLists, teamPlayer, playerDetail, maxPlayerTeam, maxTeamNumber, team1Number, team2Number, matchCounter, finishMatchs);
                                System.out.println();
                                System.out.println("The number of games played in the league so far is: " + matchCounter + " / " + finishMatchs);
                            }
                            break;

                        case "rank":
                            System.out.println("Show Rank");
                            rank.setRankFunction(rankLists, maxTeamNumber);
                            rank.finalSetRankFunction(rankLists, maxTeamNumber);
                            if (matchCounter > 0){
                                rank.rankDisplay(teamName, rankLists, maxTeamNumber);
                                System.out.println();
                                rank.rankDisplayFunction(rankLists, maxTeamNumber, teamName);
                            }
                            else {
                                System.out.println("No game has been played yet.");
                            }
                            break;

                        default:
                            System.out.println("The entry is not correct.");
                            break;
                    }
                }

                    System.out.println();
                    System.out.println("Select your Item:" + "\nnew \nbuy \nsell \nstatus \nmatch \nrank \nend");
                    item = input.next();
                    if (item.equals(endItem)){
                        System.out.println("The league was closed by the user!!");
                        flag = false;
                    }
            }
    }
}