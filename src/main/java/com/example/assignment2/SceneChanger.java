package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {


    public static void changeScene(ActionEvent event, String fxmlFileName, WebSearchDetails webSearchDetails) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
       WebSearchInterface controller = fxmlLoader.getController();
        controller.loadWebSearchDetails(webSearchDetails);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene1(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.show();
    }

}
