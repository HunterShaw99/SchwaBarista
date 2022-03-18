package com.schwabarista.baristaview.core.controllers;

import com.schwabarista.baristaview.ObserverManager;
import com.schwabarista.baristaview.core.data.OrderManager;
import com.schwabarista.baristaview.MainPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

public class DetailPageController {

    @FXML
    private Label AppLabel, OrderNumberLabel, OrderTotalLabel, PickupTimeLabel;

    @FXML
    private ListView<CoffeeModel> ConfirmListView;

    @FXML
    private HBox HeaderBar;

    @FXML
    private Button ExitButton;

    @FXML
    private Button MenuButton;

    @FXML
    private ImageView testImageView;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {

        //temporary testing stuff
        /**
         * TODO:
         * Remove this
         */
        //end

        ObservableList<CoffeeModel> newList = FXCollections.observableArrayList(OrderManager.GetInstance().GetCurrentItem().beverageLIST);

        ConfirmListView.setItems(newList);
        ConfirmListView.setCellFactory(new CoffeeCellFactory());

        OrderNumberLabel.setText("Order #" + OrderManager.GetInstance().GetCurrentItem().GetOrderID().substring(0,5));
        OrderTotalLabel.setText("$" + OrderManager.GetInstance().GetCurrentItem().Get_OrderTotal());
        //PickupTimeLabel.setText(OrderManager.GetInstance().GetCurrentItem().GetPickupTime());


    }

    @FXML
    void MenuButtonClicked(ActionEvent event) throws IOException {
        SwitchToMainPage(event);
    }

    public void CancelButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Cancelled");
        OrderManager.GetInstance().GetCurrentItem().orderStatus=OrderStatus.CANCELLED;
        SwitchToMainPage(event);
    }

    public void ConfirmButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Confirmed");
        OrderManager.GetInstance().GetCurrentItem().orderStatus=OrderStatus.DONE;
        SwitchToMainPage(event);
    }


    private void SwitchToMainPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("main-page-view.fxml"));
        MainPageController mainpagecontroller = new MainPageController(new ObserverManager());
        fxmlLoader.setController(mainpagecontroller);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }
}

