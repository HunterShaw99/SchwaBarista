package com.schwabarista.baristaview;

import com.amazonaws.services.sqs.model.Message;
import com.schwabarista.baristaview.models.OrderModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class MainPageController implements Observer {
    ReceiveOrder receiveorder;

    @FXML
    public ListView<OrderModel> MainListView;

    @FXML
    public Button QuitButton;

    public MainPageController(ObserverManager observermanager) {
        observermanager.registerObserver(this);
    }

    public void initialize() {
        MainListView.setCellFactory(new OrderCellFactory());

        // Start thread to access queue
        receiveorder = new ReceiveOrder();
        Thread t = new Thread(receiveorder);
        t.start();
    }

    public void update(List<Message> messages) {
        MainListView.setCellFactory(new OrderCellFactory());
    }

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }

}
