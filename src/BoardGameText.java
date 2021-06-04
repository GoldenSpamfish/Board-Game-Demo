import java.util.Scanner;

public class BoardGameText {


    public static void main(String [] args) {
        Scanner scan= new Scanner(System.in);
        boolean playing = true;
        boolean side = true;
        int input, xIn, yIn;


        int[][] board =
        {{0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}};
        while (playing) {
            for (int x = 0; x < 10; x++) {
                System.out.println();
                for (int y = 0; y < 10; y++) {

                    System.out.print(board[y][x] + "  ");
                }
            }
            System.out.println("\n\nEnter an X coordinate (0-9), -1 to end, or 99 to change sides");

            input=scan.nextInt();

            if (input==99){
                side = false;
            }
            else if(input==-1){
                playing=false;
            }
            else if(input<=10){
                xIn=input;

                System.out.println("Enter a Y coordinate");
                yIn=scan.nextInt();

                if(board[xIn][yIn]==1 || (board[xIn][yIn]==2)){
                    board[xIn][yIn] = 0;
                }
                else if(side){
                    board[xIn][yIn]=1;
                }
                else {
                    board[xIn][yIn]=2;
                }
            }

        }
    }
}
