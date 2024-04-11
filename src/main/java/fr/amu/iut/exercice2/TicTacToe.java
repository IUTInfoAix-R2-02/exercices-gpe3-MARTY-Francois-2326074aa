package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {
    public Node aleatoire(){
        Random random = new Random();
        int nombre = random.nextInt(3);
        ImageView croix = new ImageView("exercice2/Croix.png");
        ImageView rond = new ImageView("exercice2/Rond.png");
        ImageView vide = new ImageView("exercice2/Vide.png");
        if(nombre == 0){
            return croix;
        }
        else if(nombre == 1){
            return rond;
        }
        else return vide;
    }
    @Override
    public void start(Stage primaryStage) {


        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();
        Label label9 = new Label();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, label8, label9);

        GridPane.setConstraints(label1, 0, 0);
        GridPane.setConstraints(label2, 0, 1);
        GridPane.setConstraints(label3, 0, 2);
        GridPane.setConstraints(label4, 1, 0);
        GridPane.setConstraints(label5, 1, 1);
        GridPane.setConstraints(label6, 1, 2);
        GridPane.setConstraints(label7, 2, 0);
        GridPane.setConstraints(label8, 2, 1);
        GridPane.setConstraints(label9, 2, 2);

        gridPane.setGridLinesVisible(true);

        label1.setGraphic(aleatoire());
        label2.setGraphic(aleatoire());
        label3.setGraphic(aleatoire());
        label4.setGraphic(aleatoire());
        label5.setGraphic(aleatoire());
        label6.setGraphic(aleatoire());
        label7.setGraphic(aleatoire());
        label8.setGraphic(aleatoire());
        label9.setGraphic(aleatoire());


        Scene scene1 = new Scene(gridPane);
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }
}

