import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardGameGUI extends Application {
    int xGridCoordinate,yGridCoordinate;
    boolean side = true;
    String guiOutputText;

    Pane root = new Pane();

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

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Scene scene = new Scene(root, 1500, 1040);
        scene.setOnMousePressed(this::processMousePressed);


        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();


        updater(board,root,"program output...");
    }



    public void processMousePressed(MouseEvent mouseEvent) {
        if (20 <= mouseEvent.getX() && 1000 >= mouseEvent.getX() && 20 <= mouseEvent.getY() && 1000 >= mouseEvent.getY()){
            guiOutputText = "";

            xGridCoordinate = (int) (mouseEvent.getX() - 20) / 100;
        yGridCoordinate = (int) (mouseEvent.getY() - 20) / 100;


        if (board[xGridCoordinate][yGridCoordinate] == 1 || board[xGridCoordinate][yGridCoordinate] == 2) {
            board[xGridCoordinate][yGridCoordinate] = 0;
        } else if (side) {
            board[xGridCoordinate][yGridCoordinate] = 1;
        } else {
            board[xGridCoordinate][yGridCoordinate] = 2;
        }


        for (int y = 0; y < 10; y++) {
            System.out.println();
            guiOutputText = guiOutputText.concat("\n");
            for (int x = 0; x < 10; x++) {

                System.out.print(board[x][y] + "  ");
                guiOutputText = guiOutputText.concat(board[x][y] + "  ");
            }
        }
        System.out.println("\n" + xGridCoordinate + "," + yGridCoordinate);
        guiOutputText = guiOutputText.concat("\n\n" + xGridCoordinate + "," + yGridCoordinate);

        updater(board, root, guiOutputText);
    }
    }

    public void updater (int[][] dataStructure, Pane root, String message) {

        root.getChildren().clear();

        Text messageBox = new Text(1125, 40, message);
        messageBox.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        root.getChildren().add(messageBox);

        Button control = new Button("Change color");
        control.setLayoutX(1100);
        control.setLayoutY(400);
        control.setPrefSize(300,40);
        control.setFont(Font.font("Arial", FontWeight.NORMAL, 24));

        control.setOnAction(event -> side=!side);

        root.getChildren().add(control);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10;y++) {
                Rectangle gridBox = new Rectangle(100*x+20, 100*y+20,100,100);
                gridBox.setStroke(Color.BLACK);
                gridBox.setStrokeWidth(4);
                gridBox.setFill(Color.WHITE);
                root.getChildren().add(gridBox);

                if(dataStructure[x][y]==1){
                    Circle token = new Circle(100*x+20+50, 100*y+20+50,45);
                    token.setStroke(Color.BLACK);
                    token.setStrokeWidth(4);
                    token.setFill(Color.WHITE);
                    root.getChildren().add(token);
                }
                else if(dataStructure[x][y]==2){
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

