import javafx.application.Application;
import javafx.event.ActionEvent;
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

    DataStructure dataStructure= new DataStructure();

    //variables are moved to class scope for GUI
    int xGridCoordinate,yGridCoordinate;
    boolean side = true;
    String guiOutputText;

    //group for GUI elements
    Pane root = new Pane();

    //only needed to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }

    //core management method
    public void start(Stage primaryStage) {

        //makes scene
        Scene scene = new Scene(root, 1500, 1040);
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        //uses mouse interaction to update scene
        scene.setOnMousePressed(this::processMousePressed);

        //updater method first run here to add initial GUI elements
        updater(root,"program output...");
    }


    //mouse handler controls most interaction with the board
    //effectively replaces the user interface part of the text version
    public void processMousePressed(MouseEvent mouseEvent) {

        //makes sure click is within board
        if (20 <= mouseEvent.getX() && 1000 >= mouseEvent.getX() && 20 <= mouseEvent.getY() && 1000 >= mouseEvent.getY()){
            guiOutputText = "";

            //converts click coordinates to grid coordinates
            xGridCoordinate = (int) (mouseEvent.getX() - 20) / 100;
            yGridCoordinate = (int) (mouseEvent.getY() - 20) / 100;

        //if there is something there, remove it
        if (dataStructure.getElement(xGridCoordinate, yGridCoordinate) == 1 || dataStructure.getElement(xGridCoordinate, yGridCoordinate) == 2) {
            dataStructure.setElement(xGridCoordinate, yGridCoordinate,0 );
        }

        //if it is empty, add color based on which color is selected
        else if (side) {
            dataStructure.setElement(xGridCoordinate, yGridCoordinate, 1);
        } else {
            dataStructure.setElement(xGridCoordinate, yGridCoordinate, 2);
        }

        //makes string from data structure to display in the GUI
        //simultaneously out-prints for bug fixing and those with better IDE's
        for (int y = 0; y < 10; y++) {
            guiOutputText = guiOutputText.concat("\n");
            for (int x = 0; x < 10; x++) {
                guiOutputText = guiOutputText.concat(dataStructure.getElement(x, y) + "  ");
            }
        }
        System.out.println("\n" + xGridCoordinate + "," + yGridCoordinate);
        guiOutputText = guiOutputText.concat("\n\n" + xGridCoordinate + "," + yGridCoordinate);

        //runs updater on every click to bring DataStructure changes into the GUI
        updater(root, guiOutputText);
    }
    }

    //event handler for button
    private void buttonHandle(ActionEvent event) {
        side=!side;
        updater(root,guiOutputText+"\nside changed");
    }

    //all GUI elements are added with this every time something changes
    public void updater (Pane root, String message) {

        //empties root to prevent memory buildup
        root.getChildren().clear();

        //text box for GUI text output
        Text messageBox = new Text(1125, 40, message);
        messageBox.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        root.getChildren().add(messageBox);

        //Button to change color of pieces placed
        Button control = new Button("Change color");
        //position, size, and font
        control.setLayoutX(1100);
        control.setLayoutY(420);
        control.setPrefSize(300,40);
        control.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        //decides what happens when the button is clicked
        // thing being done goes after the -> (lambda)
        control.setOnAction(this::buttonHandle);
        root.getChildren().add(control);

        //uses for loop to create board
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10;y++) {

                //adds base grid
                Rectangle gridBox = new Rectangle(100*x+20, 100*y+20,100,100);
                gridBox.setStroke(Color.BLACK);
                gridBox.setStrokeWidth(4);
                gridBox.setFill(Color.WHITE);
                root.getChildren().add(gridBox);

                //uses data structure to check whether to add circles
                //functionally the same as text version board printing
                if(dataStructure.getElement(x,y)==1){
                    Circle token = new Circle(100*x+20+50, 100*y+20+50,45);
                    token.setStroke(Color.BLACK);
                    token.setStrokeWidth(4);
                    token.setFill(Color.WHITE);
                    root.getChildren().add(token);
                }
                else if(dataStructure.getElement(x,y)==2){
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

