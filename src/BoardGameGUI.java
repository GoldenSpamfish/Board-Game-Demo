import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

public class BoardGameGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Scanner scan = new Scanner(System.in);
        boolean playing = true;
        boolean side = true;
        int input, xIn, yIn;


        int[][] board =
       {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        while (playing) {
            for (int y = 0; y < 10; y++) {
                System.out.println();
                for (int x = 0; x < 10; x++) {

                    System.out.print(board[x][y] + "  ");
                }
            }
            System.out.println("\n\nEnter an X coordinate (1-10), 0 to end, or 99 to change sides");

            input = scan.nextInt();

            if (input == 99) {
                side = false;
            } else if (input == 0) {
                playing = false;
            } else if (input <= 10) {
                xIn = input - 1;

                System.out.println("Enter a Y coordinate");
                yIn = scan.nextInt() - 1;

                if (side) {
                    board[xIn][yIn] = 1;
                } else {
                    board[xIn][yIn] = 2;
                }
            }
        }

    }
    public void updater (int[][] DS) {
        System.out.println();
    }
}

