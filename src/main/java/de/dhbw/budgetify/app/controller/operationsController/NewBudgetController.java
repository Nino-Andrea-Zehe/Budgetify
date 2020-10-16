package de.dhbw.budgetify.app.controller.operationsController;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewBudgetController {

    public void handleClickOnX(MouseEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void handleMinimize(MouseEvent me){
        Node node = (Node) me.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.toBack();
    }
}
