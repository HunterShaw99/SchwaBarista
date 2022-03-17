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
        ObservableList<CoffeeModel> items = FXCollections.observableArrayList();
        Image image = testImageView.getImage();

        CoffeeModel c1 = new CoffeeModel();
        c1.setName("First item");
        c1.setMilk(Dairy.ALMOND);
        c1.setSize(Size.SMALL);
        c1.setPrice(CoffeePrice.SMALL_COST);
        c1.addFlavor(Flavor.CARAMEL);
        items.add(c1);

        CoffeeModel c2 = new CoffeeModel();
        c2.setName("Second item");
        c2.setMilk(Dairy.SKIM);
        c2.setSize(Size.LARGE);
        c2.setPrice(CoffeePrice.LARGE_COST);
        items.add(c2);

        CoffeeModel c3 = new CoffeeModel();
        c3.setName("Third item");
        c3.setMilk(Dairy.ALMOND);
        c3.setSize(Size.SMALL);
        c3.setPrice(CoffeePrice.SMALL_COST);
        c3.addFlavor(Flavor.CARAMEL);
        items.add(c3);

        CoffeeModel c4 = new CoffeeModel();
        c4.setName("Fourth item");
        c4.setMilk(Dairy.SKIM);
        c4.setSize(Size.LARGE);
        c4.setPrice(CoffeePrice.LARGE_COST);
        items.add(c4);

        BigDecimal total = c1.getPrice().add(c2.getPrice()).add(c3.getPrice()).add(c4.getPrice());
        OrderModel order = new OrderModel(total, items, OrderStatus.PROCESSING);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 16);

        String time = c.get(Calendar.HOUR) + ":" + String.format("%02d", c.get(Calendar.MINUTE));
        //order.SetPickupTime(time);

        OrderManager.GetInstance().AddItem(order);
        OrderManager.GetInstance().SetCurrentItem(order);
        //end

        //ConfirmListView.setItems(OrderManager.GetInstance().GetCurrentItem().GetBeverageList());
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
        OrderManager.GetInstance().RemoveCurrentItem();
        SwitchToMainPage(event);
    }

    public void ConfirmButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Confirmed");
        OrderManager.GetInstance().RemoveCurrentItem();
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

