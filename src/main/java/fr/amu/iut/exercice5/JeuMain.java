package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private Obstacle obstacle1;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        Obstacle obstacle1 = new Obstacle();
        obstacle1.setLayoutX(60);
        obstacle1.setLayoutY(60);
        obstacle1.setWidth(80);
        obstacle1.setHeight(80);
        obstacle1.setFill(Paint.valueOf("red"));
        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(1280, 720);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        root.getChildren().add(obstacle1);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double j1PrevPosX = j1.getLayoutX();
            double j1PrevPosY = j1.getLayoutY();
            double j2PrevPosX = j2.getLayoutX();
            double j2PrevPosY = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
            }
            double j1PosX = j1.getLayoutX();
            double j1PosY = j1.getLayoutY();
            if (j1PosY >= root.getHeight()-1 || j1PosX >= root.getWidth()-1 || j1.estEnCollision(obstacle1)){
                j1.setLayoutX(j1PrevPosX);
                j1.setLayoutY(j1PrevPosY);
            }
            double j2PosX = j2.getLayoutX();
            double j2PosY = j2.getLayoutY();
            if (j2PosY >= root.getHeight()-1 || j2PosX >= root.getWidth()-1 || j2.estEnCollision(obstacle1)){
                j2.setLayoutX(j2PrevPosX);
                j2.setLayoutY(j2PrevPosY);
            }
            if (j1.estEnCollision(j2)){
                Platform.exit();
            }
            j1PrevPosY = j1PosY;
            j1PrevPosX = j1PosX;
            j2PrevPosY = j2PosY;
            j2PrevPosX = j2PosX;
        });
    }


}
