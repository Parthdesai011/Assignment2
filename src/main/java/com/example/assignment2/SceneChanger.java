package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {


    //scene to change scene with details
    public static void changeScene(ActionEvent event, String fxmlFileName,String id,String title, String url, String description) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
       APIElementController controller = fxmlLoader.getController();
        controller.loadWebSearchDetails(id,title,url,description);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.show();
    }

    //Scene to get back to home page

    public static void changeScene1(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("Image/R.jpeg")));
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.show();
    }

}
