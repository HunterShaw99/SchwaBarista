package com.schwabarista.baristaview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OrderCell extends ListCell<OrderModel> {
    @FXML
    private AnchorPane base;

    @FXML
    private Button ViewButton;

    public void initialize() {
    }

    public OrderCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(OrderCell.class.getResource("OrderCell.fxml"));
            loader.setController(this);
            loader.load();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(OrderModel order, boolean empty) {
        super.updateItem(order, empty);

        if (empty || order == null) {
            setText(null);
            setGraphic(null);
        } else {

            setGraphic(base);
        }
    }
}
