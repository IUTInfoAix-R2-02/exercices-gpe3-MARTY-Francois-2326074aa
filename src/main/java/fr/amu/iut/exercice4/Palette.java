package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        label = new Label();
        label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(label, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400,200);

        bas = new HBox(10);
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10,5,10,5));

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        rouge.setOnAction(event -> {
            label.setText("Rouge choisi " + ++nbRouge + " fois");
            panneau.setStyle("-fx-background-color: #F21411");
        });
        vert.setOnAction(event -> {
            label.setText("Vert choisi " + ++nbVert + " fois");
            panneau.setStyle("-fx-background-color: #31BCA4");
        });
        bleu.setOnAction(event -> {
            label.setText("Bleu choisi " + ++nbBleu + " fois");
            panneau.setStyle("-fx-background-color: #3273A4");
        });
        bas.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(label);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
