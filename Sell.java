public class Sell {
    public static boolean checkSellFunction(int[][] teamPlayer, int maxPlayerTeam, int playerSellNumber, int teamSellNumber, int teamCounter){
        if (teamSellNumber <= 0 && playerSellNumber <= 0){
            System.out.println("player and team doesnt exist");
        }

        if (playerSellNumber <= 0){
            System.out.println("player doesnt exist");
            return false;
        }

        if (teamSellNumber <= 0){
            System.out.println("team doesnt exist");
            return false;
        }

        boolean checkPlayer = false;
        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[teamSellNumber - 1][i] == playerSellNumber){
                checkPlayer = true;
            }
        }

        if (teamSellNumber > teamCounter){
            System.out.println("team doesnt exist");
            return false;
        }
        else if (!checkPlayer) {
            System.out.println("team doesnt have this player");
            return false;
        }
        else {
            System.out.println("player sold successfully");
            return true;
        }
    }

    public static void removePlayer(int[][] teamPlayer, int maxPlayerTeam, int playerSellNumber, int teamSellNumber){
        for (int i=0; i<maxPlayerTeam; i++){
            if (teamPlayer[teamSellNumber - 1][i] == playerSellNumber){
                teamPlayer[teamSellNumber - 1][i] = 0;
            }
        }
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