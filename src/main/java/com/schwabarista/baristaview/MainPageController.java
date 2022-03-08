package com.schwabarista.baristaview;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    @FXML
    public ListView MainListView;

    @FXML
    public Button QuitButton;

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }

}
