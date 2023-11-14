public class Rank {
    public static void setRankFunction(int[][] ranklists, int maxTeamNumber){
        int temp1, temp2, temp3, temp4, temp5;

        for (int i = 0; i < maxTeamNumber - 1; i++) {
            for (int j = i+1; j < maxTeamNumber; j++) {
                int iTmp = i;
                if (ranklists[j][1] > ranklists[iTmp][1]) {
                    iTmp = j;

                    temp1 = ranklists[i][1];
                    ranklists[i][1] = ranklists[iTmp][1];
                    ranklists[iTmp][1] = temp1;

                    temp2 = ranklists[i][0];
                    ranklists[i][0] = ranklists[iTmp][0];
                    ranklists[iTmp][0] = temp2;

                    temp3 = ranklists[i][2];
                    ranklists[i][2] = ranklists[iTmp][2];
                    ranklists[iTmp][2] = temp3;

                    temp4 = ranklists[i][3];
                    ranklists[i][3] = ranklists[iTmp][3];
                    ranklists[iTmp][3] = temp4;

                    temp5 = ranklists[i][4];
                    ranklists[i][4] = ranklists[iTmp][4];
                    ranklists[iTmp][4] = temp5;
                }
            }
        }
    }

    public static void finalSetRankFunction(int[][] ranklists, int maxTeamNumber){
        int temp1, temp2, temp3, temp4, temp5;

        for (int i=0; i<maxTeamNumber - 1; i++){
            if (ranklists[i][1] == ranklists[i+1][1] && ranklists[i][0] != 0 && ranklists[i+1][0] != 0){
                if (ranklists[i][3] > ranklists[i+1][3]){
                    temp1 = ranklists[i][3];
                    ranklists[i][3] = ranklists[i + 1][3];
                    ranklists[i + 1][3] = temp1;

                    temp2 = ranklists[i][0];
                    ranklists[i][0] = ranklists[i + 1][0];
                    ranklists[i + 1][0] = temp2;

                    temp3 = ranklists[i][1];
                    ranklists[i][1] = ranklists[i + 1][1];
                    ranklists[i + 1][1] = temp3;

                    temp4 = ranklists[i][2];
                    ranklists[i][2] = ranklists[i + 1][2];
                    ranklists[i + 1][2] = temp4;

                    temp5 = ranklists[i][4];
                    ranklists[i][4] = ranklists[i + 1][4];
                    ranklists[i + 1][4] = temp5;
                }
            }
        }

        for (int i=0; i<maxTeamNumber - 1; i++){
            if (ranklists[i][1] == ranklists[i+1][1] && ranklists[i][3] == ranklists[i+1][3] && ranklists[i][0] != 0 && ranklists[i+1][0] != 0){
                if (ranklists[i][0] > ranklists[i+1][0]){
                    temp1 = ranklists[i][3];
                    ranklists[i][3] = ranklists[i + 1][3];
                    ranklists[i + 1][3] = temp1;

                    temp2 = ranklists[i][0];
                    ranklists[i][0] = ranklists[i + 1][0];
                    ranklists[i + 1][0] = temp2;

                    temp3 = ranklists[i][1];
                    ranklists[i][1] = ranklists[i + 1][1];
                    ranklists[i + 1][1] = temp3;

                    temp4 = ranklists[i][2];
                    ranklists[i][2] = ranklists[i + 1][2];
                    ranklists[i + 1][2] = temp4;

                    temp5 = ranklists[i][4];
                    ranklists[i][4] = ranklists[i + 1][4];
                    ranklists[i + 1][4] = temp5;
                }
            }
        }
    }

    public static void rankDisplay(String[] teamName, int[][] ranklists, int maxTeamNumber){
        System.out.println("Team's ID\tTeam's name\tW\tD\tL\tPts");
        for (int i=0; i<maxTeamNumber; i++){
            if (ranklists[i][0] != 0){
                System.out.print(ranklists[i][0] + "\t");
                int teamIdName = ranklists[i][0];
                System.out.print(teamName[teamIdName - 1] + "\t");
            }
            for (int j=1; j<5; j++){
                if (ranklists[i][0] != 0){
                    System.out.print(ranklists[i][j] + "\t");
                }
            }
            if (ranklists[i][0] != 0){
            System.out.println();
            }
        }
    }

    public static void rankDisplayFunction(int[][] ranklists, int maxTeamNumber, String[] teamName){
        int teamID;

        for (int i=0; i<maxTeamNumber; i++){
            if (ranklists[i][0] != 0){
                teamID = ranklists[i][0];
                System.out.print((i+1) + ". ");
                System.out.print(teamName[teamID - 1] + "\t");
                if (i+1 == 1){
                    System.out.println("Champion!");
                }
                else if (i+1 == 2){
                    System.out.println("Vice champion!!");
                }
                else {
                    System.out.println();
                }
            }
        }
    }
}