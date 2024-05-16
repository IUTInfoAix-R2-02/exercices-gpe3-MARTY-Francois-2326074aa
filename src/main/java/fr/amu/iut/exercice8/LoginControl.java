package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    String text;
    @FXML
    private void okClicked() {
        System.out.println(text);
    }

    private void cancelClicked() {
    }
}