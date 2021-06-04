import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoardGameGUI extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root, 1500, 1040);
        scene.setOnMousePressed(this::processMousePressed);

        Scanner scan = new Scanner(System.in);
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

        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        while (playing) {
            updater(board,root);
            for (int x = 0; x < 10; x++) {
                System.out.println();
                for (int y = 0; y < 10; y++) {

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

    private void processMousePressed(MouseEvent mouseEvent) {
    }

    public void updater (int[][] DS, Group root) {

        root.getChildren().clear();
        for (int y = 0; y < 10; y++) {
            System.out.println();
            for (int x = 0; x < 10;x++) {
                Rectangle gridBox = new Rectangle(100*x+20, 100*y+20,100,100);
                gridBox.setStroke(Color.BLACK);
                gridBox.setStrokeWidth(4);
                gridBox.setFill(Color.WHITE);
                root.getChildren().add(gridBox);

                if(DS[y][x]==1){
                    Circle token = new Circle(100*x+20+50, 100*y+20+50,45);
                    token.setStroke(Color.BLACK);
                    token.setStrokeWidth(4);
                    token.setFill(Color.WHITE);
                    root.getChildren().add(token);
                }
                else if(DS[y][x]==2){
                    Circle token = new Circle(100*x+20+50, 100*y+20+50,45);
                    token.setStroke(Color.BLACK);
                    token.setStrokeWidth(4);
                    token.setFill(Color.BLACK);
                    root.getChildren().add(token);
                }
            }
        }
    }
}

