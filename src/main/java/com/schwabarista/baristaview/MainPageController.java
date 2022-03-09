package com.schwabarista.baristaview;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController {

    @FXML
    public ListView<OrderModel> MainListView;

    @FXML
    public Button QuitButton;

    public void initialize() {
        MainListView.setCellFactory(new OrderCellFactory());
    }

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }
}
