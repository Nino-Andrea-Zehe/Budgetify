package de.dhbw.budgetify.app.controller.signOutController;



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


public class SignOutController {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button btnClose;

    public void closeEverything(MouseEvent ev){
        Node node = (Node) ev.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        if (ev.getSource() == btnClose){
            /*CLOSE HOME AND OPEN SIGN IN WINDOW*/

            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/logIn/LoginWindow.fxml"));
                stage.setTitle("Budgetify");
                stage.setResizable(false);
                stage.setMaximized(false);

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

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            }catch (IOException ex){
                System.err.println(ex.getMessage());
            }
        }

    }
}
