import java.util.Scanner;

public class Team {
    public static boolean teamNameFunction(String[] teamName, int teamCounter){
        Scanner input = new Scanner(System.in);
        boolean confirm = true;
        while (confirm){
            System.out.println("Enter your team name:");
            String checkTeamName = input.next();
            for (int i=0; i<=teamCounter; i++){
                if (checkTeamName.equals(teamName[i])){
                    System.out.println("The team already exists.");
                    return false;
                }
                else {
                    teamName[teamCounter] = checkTeamName;
                    confirm = false;
                    return true;
                }
            }

        }
        return true;
    }

    public static void teamDetailFunction(int[][] teamDetail, int teamCounter){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the team budget:");
        teamDetail[teamCounter][0] = input.nextInt();
    }

    public static void teamDisplay(int[] idList, String[] teamName, int[][] teamDetail, int teamCounter){
        System.out.println("Team's ID\tTeam's name\tBudget");
        for (int i=0; i<=teamCounter; i++){
            System.out.print(idList[i] + "\t");
            System.out.print(teamName[i] + "\t");
            System.out.println(teamDetail[i][0]);
        }
    }
}