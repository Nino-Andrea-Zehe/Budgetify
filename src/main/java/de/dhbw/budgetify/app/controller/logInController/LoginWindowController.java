package de.dhbw.budgetify.app.controller.logInController;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class LoginWindowController{

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private Circle forgotUsername;

    @FXML
    private Circle forgotPassword;

    private int permission = 0;
    private String fileName;

    private double xOffset = 0;
    private double yOffset = 0;


    /*LOG IN USING ENTER*/
    public void onEnter(ActionEvent ae){
        /*
        ASK FOR PERMISSION
         */
        if (logIn().equals("Success")) {
            Node node = (Node) ae.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            switch (permission) {
                case 0:
                    fileName = "Admin";
                    break;

                case 1:
                    fileName = "User";
                    break;

                case 2:
                    fileName = "Finance";
                    break;
            }
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/home/Home" + fileName + ".fxml"));
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
                Scene main = new Scene(root);
                stage.setScene(main);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }


    /*LOG IN USING MOUSE*/
    public void handleButtonAction(MouseEvent event) {
        /*
        ASK FOR PERMISSION
         */
        if (event.getSource() == btnSignIn) {
            if (logIn().equals("Success")) {
                Node node = (Node) event.getSource();
                final Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                switch (permission) {
                    case 0:
                        fileName = "Admin";
                        break;

                    case 1:
                        fileName = "User";
                        break;

                    case 2:
                        fileName = "Finance";
                        break;
                }
                try {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/home/Home" + fileName + ".fxml"));
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
                    Scene main = new Scene(root);
                    stage.setScene(main);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void handleClickOnX(MouseEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    private String logIn(){
        String status;
        String username = txtUsername.getText();
        String password = pwdPassword.getText();
        forgotUsername.setVisible(false);
        forgotPassword.setVisible(false);
        if (username.isEmpty() || password.isEmpty()) {
            if(username.isEmpty() && !password.isEmpty()){
                forgotUsername.setVisible(true);
                System.out.println("Fill Username");
            }
            if(password.isEmpty() && !username.isEmpty()){
                forgotPassword.setVisible(true);
                System.out.println("Fill Password");
            }
            if(password.isEmpty() && username.isEmpty()){
                forgotUsername.setVisible(true);
                forgotPassword.setVisible(true);
                System.out.println("Fill Both");
            }
            status = "Error";
        }else{

            status = "Success";
            System.out.println("Logged in");
            /*
            IMPLEMENT LOG IN INTERFACE
             */
        }
        return status;
    }
}