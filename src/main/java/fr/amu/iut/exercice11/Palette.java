package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");

    public String getCouleurPanneau() {
        return couleurPanneau.get();
    }

    public StringProperty couleurPanneauProperty() {
        return couleurPanneau;
    }

    public void setCouleurPanneau(String couleurPanneau) {
        this.couleurPanneau.set(couleurPanneau);
    }

    private StringProperty message = new SimpleStringProperty();

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    private IntegerProperty nbFois = new SimpleIntegerProperty(0);

    public int getNbFois() {
        return nbFois.get();
    }

    public IntegerProperty nbFoisProperty() {
        return nbFois;
    }

    public void setNbFois(int nbFois) {
        this.nbFois.set(nbFois);
    }

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label labelHaut;
    private Label labelBas;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        labelHaut = new Label();
        labelHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(labelHaut, Pos.CENTER);

        labelBas = new Label();
        labelBas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(labelBas, Pos.BASELINE_RIGHT);

        panneau = new Pane();
        panneau.setPrefSize(400,200);

        bas = new HBox(10);
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10,5,10,5));




        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        setMessage("Rien n'est");
        labelHaut.textProperty().bind(Bindings.concat(message, " est appuyé ", nbFois, " fois"));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color: ", couleurPanneau));
        labelBas.textProperty().bind(Bindings.concat("Le ", message, " est une jolie couleur !"));
        labelBas.fontProperty().bind(Bindings.concat("-fx-font-color", couleurPanneau));

        rouge.setOnAction(event -> {
            setMessage(rouge.getText());
            nbRouge++;
            setNbFois(nbRouge);
            setCouleurPanneau("#F21411");
        });

        vert.setOnAction(event -> {
            setMessage(vert.getText());
            nbVert++;
            setNbFois(nbVert);
            setCouleurPanneau("#31BCA4");
        });

        bleu.setOnAction(event -> {
            setMessage(bleu.getText());
            nbBleu++;
            setNbFois(nbBleu);
            setCouleurPanneau("#3273A4");
        });
        bas.getChildren().addAll(vert, rouge, bleu);
        VBox VBox = new VBox(bas, labelBas);
        root.setCenter(panneau);
        root.setTop(labelHaut);
        root.setBottom(VBox);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
