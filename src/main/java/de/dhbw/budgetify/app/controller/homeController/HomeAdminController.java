package de.dhbw.budgetify.app.controller.homeController;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeAdminController {

    String path;
    String name;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button newBudget;

    @FXML
    private Button amendBudget;

    @FXML
    private Button statsReview;

    @FXML
    private Button admin;

    public void handleButtonAction(MouseEvent event){
        if (event.getSource() == newBudget){
            path = "NewBudget";
            name = "New Budget";
        }else if (event.getSource() == amendBudget){
            path = "AmendBudget";
            name = "Amend Budget";

        }else if (event.getSource() == statsReview){
            path = "StatsReview";
            name = "Stats";
        }else {
            path = "Admin";
            name = "Admin Panel";
        }
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/operations/"+path+".fxml"));
            final Stage stage = new Stage();
            stage.setScene(new Scene(root));
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            stage.setTitle(name);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.getIcons().add(new Image("img/Budget2.png"));
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.show();
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }

    }

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

    public void signOut(MouseEvent cl){
        Node node = (Node) cl.getSource();
        Stage home = (Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/signOut/signOut.fxml"));
            final Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.show();

        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
