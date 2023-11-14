public class Status {
    public static void teamsStatus(String[] teamName, int[][] teamDetail, int teamCounter){
        System.out.println("Team's ID\tTeam's name\tNumber of players\tBudget\tValue");
        for (int i=0; i<teamCounter; i++){
            System.out.print((i+1) + "\t");
            System.out.print(teamName[i] + "\t");
            System.out.print(teamDetail[i][2] + "\t");
            System.out.print(teamDetail[i][0] + "\t");
            System.out.print(teamDetail[i][1] + "\t");
            System.out.println();
        }
    }
}