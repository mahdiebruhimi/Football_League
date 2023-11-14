import java.util.Scanner;

public class Player {
    public static void playerNameFunction(String[] playerName, int playerCounter){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your player name:");
        playerName[playerCounter] = input.next();
    }
    public static  void playerDetailFunction(int[][] playerDetail, int playerCounter){

        Scanner input = new Scanner(System.in);
        for (int i=0; i<4; i++){
            switch (i){
                case 0:
                    System.out.println("Enter player's price:");
                    break;
                case 1:
                    System.out.println("Enter player's speed:");
                    break;
                case 2:
                    System.out.println("Enter player's finishing:");
                    break;
                case 3:
                    System.out.println("Enter player's defence:");
                    break;
            }
            playerDetail[playerCounter][i] = input.nextInt();
        }
    }
    public static void playerDisplay(int[] idList, String[] playerName, int[][] playerDetaile, int playerCounter){
        System.out.println("Player's ID\tPlayer's name\tPrice\tSpeed\tFinishing\tDefence");
        for (int i=0; i<=playerCounter; i++){
            System.out.print(idList[i] + "\t");
            System.out.print(playerName[i] + "\t");
            for (int j=0; j<4; j++){
                System.out.print(playerDetaile[i][j] + "\t");
            }
            System.out.println();
        }
    }
}