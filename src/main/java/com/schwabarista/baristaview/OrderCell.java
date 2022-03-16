package com.schwabarista.baristaview;

import com.schwabarista.baristaview.models.OrderModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class OrderCell extends ListCell<OrderModel> {

    @FXML
    private AnchorPane base;

    @FXML
    private Button ViewButton;

    @FXML
    private Label drinkNumber;

    @FXML
    private Label orderID;

    @FXML
    private Label orderStatus;

    @FXML
    private Label orderTotal;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
    }

    @FXML
    void viewButtonPressed(ActionEvent event) {

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
            orderID.setText(order.GetOrderID());
            drinkNumber.setText(String.valueOf(order.GetBeverageList().size()));
            orderTotal.setText("$" + order.Get_OrderTotal().toString());
            orderStatus.setText(order.GetOrderStatus().toString());
            ViewButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detail-page-view.fxml"));
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            });
            setGraphic(base);
        }
    }
}
