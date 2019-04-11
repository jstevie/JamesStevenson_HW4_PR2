import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlPolygon extends Application {
    private RegularPolygonPane polygonPane = new RegularPolygonPane();
    private int numOfSides = 4;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btIncrease = new Button("+");
        Button btDecrease = new Button("-");
        Button btUpdate = new Button ("Update Polygon");
        hBox.getChildren().add(btIncrease);
        hBox.getChildren().add(btDecrease);
        hBox.getChildren().add(btUpdate);

        // Create and register the handler
        btIncrease.setOnAction(new IncreaseHandler());
        btDecrease.setOnAction(new DecreaseHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(polygonPane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * When '+' button is pressed, number of sides is increased by one
     */
    class IncreaseHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            polygonPane.plus();
        }
    }

    /**
     * When '-' button is pressed, number of sides is decreased by one
     */
    class DecreaseHandler implements EventHandler<ActionEvent> {
        @Override //Override the handle method
        public void handle (ActionEvent e) {
            polygonPane.minus();
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}