package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoJavaFX extends Application {

    private TextField textField;

    public void start(Stage primaryStage) {
        // Create a label to display the message
        Label messageLabel = new Label();
        
        // Create a text field for user input
        TextField inputField = new TextField();
        
        // Create a button to trigger the action
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String userInput = inputField.getText();
            messageLabel.setText("User wrote: " + userInput);
        });

        // Add the label, text field, and button to a layout container
        VBox root = new VBox();
        root.getChildren().addAll(messageLabel, inputField, submitButton);
        
        // Set the scene with the layout container as the root
        Scene scene = new Scene(root, 300, 200);
        
        // Set the stage's title and scene, then show the stage
        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
