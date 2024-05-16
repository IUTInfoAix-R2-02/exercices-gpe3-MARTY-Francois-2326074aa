package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        char[] lettreDecouverte = new char['0'];
        String motImport = "feur";

        String motADeviner = "";
        for (int i = 0;i < motImport.length(); i++){
            for (int j = 0; j < lettreDecouverte.length; j++){
            }
            motADeviner = motADeviner + '*';
        }
        Label labelMotDeviner = new Label(motADeviner);

        VBox vbox1 = new VBox(labelMotDeviner);
        Scene scene1 = new Scene(vbox1, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
