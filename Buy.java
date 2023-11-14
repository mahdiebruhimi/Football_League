public class Buy {
    public static boolean checkBuyFunction(int[][] teamPlayer, int maxTeamNumber, int maxPlayerTeam, int[][] playerDetail, int[][] teamDetail, int playerBuyNumber, int teamBuyNumber, int playerCounter, int teamCounter){
        boolean checkPlayerFree = true;
        for (int i=0; i<maxTeamNumber; i++){
            for (int j=0; j<maxPlayerTeam; j++){
                if (teamPlayer[i][j] == playerBuyNumber){
                    checkPlayerFree = false;
                }
            }
        }

        if (playerBuyNumber > playerCounter || playerBuyNumber <= 0){
            System.out.println("player with the id playerID doesnt exist");
            return false;
        }
        else if (teamBuyNumber > teamCounter || teamBuyNumber <= 0) {
            System.out.println("team with the id teamID doesnt exist");
            return false;
        }
        else if (playerDetail[playerBuyNumber - 1][0] > teamDetail[teamBuyNumber - 1][0]){
            System.out.println("the team cant afford to buy this player");
            return false;
        }
        else if (!checkPlayerFree) {
            System.out.println("player already has a team");
            return false;
        }
        else {
            System.out.println("player added to the team succesfully");
            return true;
        }
    }

    public static boolean addPlayerFunction(int[][] teamPlayer, int teamBuyNumber, int playerBuyNumber, int maxPlayerTeam){
        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[teamBuyNumber - 1][i] == 0){
                teamPlayer[teamBuyNumber - 1][i] = playerBuyNumber;
                return true;
            }
        }
        return false;
    }

    public static void teamPlayerDisplayFunction(String[] teamName, int[] idList, int[][] teamPlayer, int maxTeamNumber, int maxPlayerTeam){
        System.out.println("Team's ID\tTeam's name\tPlayers ID");
        for (int i=0; i<maxTeamNumber; i++){
            if (teamPlayer[i][0] != 0){
                System.out.print(idList[i] + "\t" + teamName[i] + "\t");
            }
            for (int j=0; j<maxPlayerTeam; j++){
                if (teamPlayer[i][j] != 0){
                    System.out.print(teamPlayer[i][j] + "\t");
                }
            }
            if (teamPlayer[i][0] != 0){
                System.out.println();
            }
        }
    }
}