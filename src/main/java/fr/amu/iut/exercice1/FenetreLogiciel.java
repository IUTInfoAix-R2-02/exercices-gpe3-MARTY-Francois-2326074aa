package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {


@Override
public void start(Stage primaryStage) {
    BorderPane BPane1 = new BorderPane();
    BPane1.getChildren().addAll();
    MenuItem mI1 = new MenuItem("New");
    MenuItem mI2 = new MenuItem("Open");
    MenuItem mI3 = new MenuItem("Save");
    MenuItem mI4 = new MenuItem("Close");
    MenuItem mI5 = new MenuItem("Cut");
    MenuItem mI6 = new MenuItem("Copy");
    MenuItem mI7 = new MenuItem("Paste");
    Menu menu1 = new Menu("File");
    Menu menu2 = new Menu("Options");
    Menu menu3 = new Menu("Help");
    menu1.getItems().addAll(mI1, mI2, mI3, mI4);
    menu2.getItems().addAll(mI5, mI6, mI7);
    MenuBar menuBar1 = new MenuBar(menu1, menu2, menu3);
    VBox vbox1 = new VBox();
    Separator sep1 = new Separator(Orientation.VERTICAL);
    HBox hbo1 = new HBox(vbox1, sep1);
    hbo1.setAlignment(Pos.CENTER);

    Label label1 = new Label("Boutons :");
    Button b1 = new Button("Bouton 1");
    Button b2 = new Button("Bouton 2");
    Button b3 = new Button("Bouton 3");
    vbox1.setAlignment(Pos.CENTER);
    vbox1.setSpacing(10);
    vbox1.getChildren().addAll(label1, b1, b2, b3);
    Separator sep2 = new Separator();
    Label label2 = new Label("Ceci est un label de bas de page");
    VBox vbox2 = new VBox(sep2, label2);
    vbox2.setAlignment(Pos.CENTER);

    SplitPane splitPane1 = new SplitPane();
    splitPane1.setPrefSize(200, 200);

    GridPane gridPane1 = new GridPane();
    Label label3 = new Label("Name:");
    Label label4 = new Label("Email:");
    Label label5 = new Label("Password:");
    TextField text1 = new TextField();
    TextField text2 = new TextField();
    TextField text3 = new TextField();
    gridPane1.getChildren().addAll(label3, label4, label5, text1, text2, text3);
    gridPane1.setAlignment(Pos.CENTER);
    GridPane.setConstraints(label3, 0, 0);
    GridPane.setConstraints(label4, 0, 1);
    GridPane.setConstraints(label5, 0, 2);
    GridPane.setConstraints(text1, 1, 0);
    GridPane.setConstraints(text2, 1, 1);
    GridPane.setConstraints(text3, 1, 2);
    gridPane1.setHgap(10);
    gridPane1.setVgap(10);


    BPane1.setTop(menuBar1);
    BPane1.setLeft(hbo1);
    BPane1.setBottom(vbox2);
    BPane1.setCenter(gridPane1);
    Scene scene1 = new Scene(BPane1, 600, 400);
    primaryStage.setScene(scene1);
    primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);

    }
}

