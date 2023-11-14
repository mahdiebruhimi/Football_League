public class Match {
    public static boolean checkMatch(int[][] teamMatch, int[][] teamPlayer, int maxPlayerTeam, int team1Number, int team2Number, int teamCounter){
        int team1PlayerNumber = 0;
        int team2PlayerNumber = 0;

        boolean notRepeat = true;
        for (int i=0; i<teamCounter - 1; i++){
                if (teamMatch[team1Number - 1][i] == team2Number) {
                    notRepeat = false;
                }
                if (teamMatch[team2Number - 1][i] == team1Number) {
                    notRepeat = false;
                }
        }

        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[team1Number - 1][i] != 0){
                team1PlayerNumber ++;
            }
            if (teamPlayer[team2Number - 1][i] != 0){
                team2PlayerNumber ++;
            }
        }

        if (team1Number > teamCounter || team2Number > teamCounter || team1Number <= 0 || team2Number <= 0){
            System.out.println("team doesnt exist");
            return false;
        }
        else if (team1PlayerNumber < 11 || team2PlayerNumber < 11) {
            System.out.println("the game can not be held due to loss of the players");
            return false;
        }
        else if (team1Number == team2Number) {
            System.out.println("The ID of both teams is the same.");
            return false;
        }
        else if (!notRepeat) {
            System.out.println("The game has already been played!");
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean teamMatchFunction(int[][] teamMatch, int maxTeamNumber, int team1Number, int team2Number){
        for (int i=0; i<maxTeamNumber; i++){
            if (teamMatch[team1Number - 1][i] == 0){
                teamMatch[team1Number - 1][i] = team2Number;
                return true;
            }
            if (teamMatch[team2Number - 1][i] == 0){
                teamMatch[team2Number - 1][i] = team1Number;
                return true;
            }
        }
        return false;
    }

    public static void resultMatch(String[] teamName, int[][] teamDetail, int[][] matchLists, int[][] rankLists, int[][] teamPlayer, int[][] playerDetail, int maxPlayerTeam, int maxTeamNumber, int team1Number, int team2Number, int matchCounter, int finishMatchs){
        int powTeam1 = 0;
        int powTeam2 = 0;
        int playerSelect;
        int team1Counter = 0;
        int team2Counter = 0;

        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[team1Number - 1][i] !=0){
                playerSelect = teamPlayer[team1Number - 1][i];
                team1Counter ++;
                if (team1Counter < 12){
                    powTeam1 += playerDetail[playerSelect - 1][1];
                    powTeam1 += playerDetail[playerSelect - 1][2];
                }
            }
        }

        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[team2Number - 1][i] !=0){
                playerSelect = teamPlayer[team2Number - 1][i];
                team2Counter ++;
                if (team2Counter < 12){
                    powTeam2 += playerDetail[playerSelect - 1][1];
                    powTeam2 += playerDetail[playerSelect - 1][3];
                }
            }
        }

        if (powTeam1 > powTeam2){
            System.out.println("The " + teamName[team1Number - 1] + " team won the game.");
            System.out.println("The result of the game:\n" + teamName[team1Number - 1] + ": " + powTeam1 + "\n" + teamName[team2Number - 1] + ": " + powTeam2);
            matchLists[team1Number -1][0] = team1Number;
            matchLists[team1Number - 1][1] ++;
            matchLists[team1Number - 1][4] += 3;
            matchLists[team2Number -1][0] = team2Number;
            matchLists[team2Number - 1][3] ++;
            teamDetail[team1Number - 1][0] += 1000;
        }
        else if (powTeam2 > powTeam1){
            System.out.println("The " + teamName[team2Number - 1] + " team won the game.");
            System.out.println("The result of the game:\n" + teamName[team1Number - 1] + ": " + powTeam1 + "\n" + teamName[team2Number - 1] + ": " + powTeam2);
            matchLists[team1Number -1][0] = team1Number;
            matchLists[team1Number - 1][3] ++;
            matchLists[team2Number -1][0] = team2Number;
            matchLists[team2Number - 1][1] ++;
            matchLists[team2Number - 1][4] += 3;
            teamDetail[team2Number - 1][0] += 1000;
        }
        else {
            System.out.println("The game equalised!");
            System.out.println("The result of the game:\n" + teamName[team1Number - 1] + ": " + powTeam1 + "\n" + teamName[team2Number - 1] + ": " + powTeam2);
            matchLists[team1Number -1][0] = team1Number;
            matchLists[team1Number - 1][2] ++;
            matchLists[team1Number - 1][4] += 1;
            matchLists[team2Number -1][0] = team2Number;
            matchLists[team2Number - 1][2] ++;
            matchLists[team2Number - 1][4] += 1;
        }

        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<5; j++){
                rankLists[i][j] = matchLists[i][j];
            }
        }

        if (matchCounter == finishMatchs){
            System.out.println("The league games are over!\nEnter \"rank\" to see the league ranking.");
        }
    }
}