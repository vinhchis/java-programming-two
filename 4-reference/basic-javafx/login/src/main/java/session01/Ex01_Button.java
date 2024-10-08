package session01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ex01_Button extends Application implements EventHandler<ActionEvent> {

    Button btnEast, btnWest, btnSouth;
    Label lblMessage;

    @Override
    public void handle(ActionEvent e) {
        if(e.getSource() == btnSouth){
            new Alert(Alert.AlertType.INFORMATION, "South says: Hello, How are you?").showAndWait();
            lblMessage.setText("South says: Hello, How are you?");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First JavaFX Application");
        btnEast = new Button();
        btnEast.setText("Hello, East");
        btnWest = new Button("Hello, West");
        btnSouth = new Button("Hello, South");
        lblMessage = new Label("JavaFx ...");

        // anonymous inner class
        btnEast.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                new Alert(Alert.AlertType.INFORMATION, "East says: Hello, How are you?").showAndWait();
                lblMessage.setText("East says: Hello, How are you?");
            }
        });
        
        // lambda Expression
        btnWest.setOnAction((e) -> {
            new Alert(Alert.AlertType.INFORMATION, "West says: Hello, How are you?").showAndWait();
            lblMessage.setText("West says: Hello, How are you?");
            
        });
        
        
        btnSouth.setOnAction(this);
        
        // layout
        FlowPane layout = new FlowPane();
        layout.setHgap(25);
        layout.getChildren().add(btnEast);
        layout.getChildren().add(btnWest);
        layout.getChildren().add(btnSouth);
        layout.getChildren().add(lblMessage);
        
        // scene
        Scene scene = new Scene(layout, 500, 300);
        
        // add and call scene to Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
