package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("apiSearch-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("WebSearch");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        launch();


        APIUtility apiUtility = new APIUtility();
        apiUtility.getWebSearchFromRapidApi("TaylorSwift");
    }
}