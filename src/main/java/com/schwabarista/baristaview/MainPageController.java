package com.schwabarista.baristaview;

import com.schwabarista.baristaview.models.OrderModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class MainPageController implements Observer {

    @FXML
    public ListView<OrderModel> MainListView;

    @FXML
    public Button QuitButton;

    public MainPageController(ObserverManager observermanager) {
        observermanager.registerObserver(this);
    }

    public void initialize() {
        MainListView.setCellFactory(new OrderCellFactory());
    }

    public void update() {

    }

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }

}
