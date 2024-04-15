package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {
    private Label helloLabel;

    private TextField nameField;

    private Button button;

    EventHandler<MouseEvent> buttonClickHandler = actionEvent -> {
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
    };
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add(helloLabel);
        primaryStage.setTitle("Hello application");
        TextField nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        vbox.getChildren().add( nameField );
        Button button = new Button("");
        vbox.getChildren().add( button );
        Image image = new Image("exercice3/silver_button.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        button.setGraphic( iv );
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, buttonClickHandler);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
