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

public class TemplateGUI extends Application {

    //initialization Section
    String guiOutputText;
    Pane root = new Pane();
    DataStructure dataStructure= new DataStructure();
    boolean toggle=true;

    //only needed to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }

    //core management method
    public void start(Stage primaryStage) {

        //makes scene
        Scene scene = new Scene(root, 1500, 1040);

        //uses mouse interaction to update scene
        scene.setOnMousePressed(this::processMousePressed);

        //handles primary stage
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        //updater method first run here to add initial GUI elements
        updater(root,"program output...\nclick to show/hide box");
    }

    //mouse handler controls most interaction with the board
    public void processMousePressed(MouseEvent mouseEvent) {

            //method to get mouse coordinates for later use
            double x= mouseEvent.getX();
            double y= mouseEvent.getY();

            //demonstrates text output window
            // text output is useful if a parallel text console does not exist
            guiOutputText = "Coordinates of click: "+x+","+y +"\nclick to show/hide box";

            //edits data structure on every mouse press
            //makes square disappear and reappear
            if (dataStructure.getElement(0,0)==0) {
                dataStructure.setElement(0, 0, 1);
            }

            else if (dataStructure.getElement(0,0)==1){
                dataStructure.setElement(0,0,0);
            }

            //runs updater on every click to bring DataStructure changes into the GUI
            updater(root, guiOutputText);
    }

    //event handler for button
    private void buttonHandle(ActionEvent event) {
        toggle=!toggle;
        updater(root,guiOutputText+"\ndot toggled!");
    }

    //all GUI elements are added with this every time something changes
    public void updater (Pane root, String message) {

        //empties root to prevent memory buildup
        root.getChildren().clear();

        //text box for GUI text output
        Text messageBox = new Text(1125, 40, message);
        messageBox.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        root.getChildren().add(messageBox);

        //Button Demonstration
        Button control = new Button("Button");
        //position, size, and font
        control.setLayoutX(1100);
        control.setLayoutY(420);
        control.setPrefSize(300,40);
        control.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        //decides what happens when the button is clicked
        //thing it should do goes in buttonHandle method
        control.setOnAction(this::buttonHandle);
        root.getChildren().add(control);

        //uses effect of button event
        if (toggle){
            Circle toggleIndicator = new Circle(1250, 550,45);
            toggleIndicator.setFill(Color.GREEN);
            root.getChildren().add(toggleIndicator);
        }

        //checks data structure and uses it to decide to display a box
        if (dataStructure.getElement(0,0) == 0){
            Rectangle gridBox = new Rectangle(500, 500,100,100);
            root.getChildren().add(gridBox);
        }

    }
}

