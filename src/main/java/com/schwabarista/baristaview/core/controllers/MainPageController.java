package com.schwabarista.baristaview.core.controllers;

import com.amazonaws.services.sqs.model.Message;
import com.schwabarista.baristaview.Observer;
import com.schwabarista.baristaview.ObserverManager;
import com.schwabarista.baristaview.OrderCellFactory;
import com.schwabarista.baristaview.ReceiveOrder;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MainPageController implements Observer {
    ReceiveOrder receiveorder;
    ObservableList<OrderModel> orders = FXCollections.observableArrayList();

    @FXML
    public ListView<OrderModel> MainListView;

    @FXML
    public Button QuitButton;

    private ObservableList<OrderModel> listOfItems = FXCollections.observableArrayList();

    public MainPageController(ObserverManager observermanager) {
        observermanager.registerObserver(this);
    }

    public void initialize() {
        MainListView.setItems(orders);
        MainListView.setCellFactory(new OrderCellFactory());

        // Start thread to access queue
        receiveorder = new ReceiveOrder();
        Thread t = new Thread(receiveorder);
        t.start();
    }

    public void update(List<Message> messages) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String message = messages.get(0).getBody();
        OrderModel order = objectMapper.readValue(message, OrderModel.class);
        orders.add(order);

        MainListView.setItems(orders);
        MainListView.setCellFactory(new OrderCellFactory());
    }

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }

}
