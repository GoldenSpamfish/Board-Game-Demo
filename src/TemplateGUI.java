import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TemplateGUI extends Application {
    String guiOutputText;
    Pane root = new Pane();
    int[] DataStructure ={0,1,2,3,4};

    String doThing;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Scene scene = new Scene(root, 1500, 1040);
        scene.setOnMousePressed(this::processMousePressed);

        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        updater(DataStructure,root,"program output...");
    }


    public void processMousePressed(MouseEvent mouseEvent) {

            double x= mouseEvent.getX();
            double y= mouseEvent.getY();
            guiOutputText = x+","+y;

            updater(DataStructure, root, guiOutputText);
    }

    public void updater (int[] DataStructure, Pane root, String message) {

        root.getChildren().clear();

        Text messageBox = new Text(1125, 40, message);
        messageBox.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        root.getChildren().add(messageBox);

        Button control = new Button("Button");
        control.setLayoutX(1100);
        control.setLayoutY(400);
        control.setPrefSize(300,40);
        control.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        control.setOnAction(event -> doThing="do thing on button press");
        root.getChildren().add(control);


        if (DataStructure[0] == 0){
            Rectangle gridBox = new Rectangle(500, 500,100,100);
            root.getChildren().add(gridBox);
        }

    }
}

