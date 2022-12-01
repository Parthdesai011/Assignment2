package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class APISearchController  implements Initializable {

    APIElementController apiElementController;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listView"
    private ListView<WebSearch> listView; // Value injected by FXMLLoader

    @FXML // fx:id="srcBtn"
    private Button srcBtn; // Value injected by FXMLLoader

    @FXML // fx:id="searchTxt"
    private TextField searchTxt; // Value injected by FXMLLoader

    @FXML // fx:id="detailsBtn"
    private Button detailsBtn; // Value injected by FXMLLoader

    @FXML
    void getDetails(ActionEvent event) throws IOException, InterruptedException {

            WebSearch webSearchSelected = listView.getSelectionModel().getSelectedItem();

            SceneChanger.changeScene(event, "apiElement-view.fxml", webSearchSelected.getId(),webSearchSelected.getTitle(),webSearchSelected.getUrl(),webSearchSelected.getDescription());







    }

    @FXML
    void OnSearch(ActionEvent event) throws IOException, InterruptedException {

        listView.getItems().clear();

        String searchTerm = searchTxt.getText();

        APIResponse apiResponse = APIUtility.getWebSearchFromRapidApi(searchTerm);

            listView.getItems().addAll(apiResponse.getWebSearches());









    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {








    }
}
