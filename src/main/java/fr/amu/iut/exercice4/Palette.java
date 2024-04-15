package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    public void start(Stage primaryStage) throws Exception {
        this.nbVert = 0;
        this.nbRouge = 0;
        this.nbBleu = 0;
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        this.root = new BorderPane();
        this.label = new Label();
        this.panneau = new Pane();
        this.bas = new HBox();
        HBox hBox1 = new HBox(label);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            if(nbVert == 2){
                label.setText("Vert choisi 3 fois");
                panneau.setStyle("-fx-background-color:green;");
            }
            else{
                nbVert++;
            }
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            if(nbRouge == 2){
                label.setText("Rouge choisi 3 fois");
                panneau.setStyle("-fx-background-color:red;");
            }
            else{
                nbRouge++;
            }
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            if(nbBleu == 2){
                label.setText("Bleu choisi 3 fois");
                panneau.setStyle("-fx-background-color:blue;");
            }
            else{
                nbBleu++;
            }
        });

        hBox1.setAlignment(Pos.CENTER);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(10);
        bas.getChildren().addAll(vert, rouge, bleu);
        root.setTop(hBox1);
        root.setCenter(panneau);
        root.setBottom(bas);
        Scene scene1 = new Scene(root, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}

