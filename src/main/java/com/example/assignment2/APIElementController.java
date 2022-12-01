package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class APIElementController implements Initializable, WebSearchInterface {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backBtn"
    private Button backBtn; // Value injected by FXMLLoader

    @FXML // fx:id="description"
    private Label description; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private Label id; // Value injected by FXMLLoader

    @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private Label title; // Value injected by FXMLLoader

    @FXML // fx:id="urlLabel"
    private Label urlLabel; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {

        try {

            SceneChanger.changeScene1 (event, "apiSearch-view.fxml" );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @Override
    public void loadWebSearchDetails(WebSearchDetails webSearchDetails) {

        id.setText(webSearchDetails.getId());
        urlLabel.setText(webSearchDetails.getUrl());
        title.setText(webSearchDetails.getTitle());
        description.setText(webSearchDetails.getDescription());


    }
}
