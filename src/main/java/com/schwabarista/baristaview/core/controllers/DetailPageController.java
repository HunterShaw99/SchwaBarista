package com.schwabarista.baristaview.core.controllers;

//import com.schwa.schwacoffe.core.data.CartManager;
import com.schwabarista.baristaview.MainPage;
import com.schwabarista.baristaview.models.CoffeeModel;
import com.schwabarista.baristaview.models.constants.CoffeePrice;
import com.schwabarista.baristaview.models.constants.Dairy;
import com.schwabarista.baristaview.models.constants.Flavor;
import com.schwabarista.baristaview.models.constants.Size;
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

public class DetailPageController {

    @FXML
    private Label AppLabel;

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

    /**
     * TODO:
     * this is the same as the confirmation page, make some adjustments so that
     *      the page makes more sense in this different context.
     *
     */

    public void initialize() {

        //temporary testing stuff
        /**
         * TODO:
         * Replace with:
         * list of items from selected OrderModel
         */
        ObservableList<CoffeeModel> items = FXCollections.observableArrayList();

        Image image = testImageView.getImage();

        CoffeeModel c1 = new CoffeeModel(image.getUrl());
        c1.setName("First item");
        c1.setMilk(Dairy.ALMOND);
        c1.setSize(Size.SMALL);
        c1.setPrice(CoffeePrice.SMALL_COST);
        c1.addFlavor(Flavor.CARAMEL);
        items.add(c1);

        CoffeeModel c2 = new CoffeeModel(image.getUrl());
        c2.setName("Second item");
        c2.setMilk(Dairy.SKIM);
        c2.setSize(Size.LARGE);
        c2.setPrice(CoffeePrice.LARGE_COST);
        items.add(c2);

        CoffeeModel c3 = new CoffeeModel(image.getUrl());
        c3.setName("Third item");
        c3.setMilk(Dairy.ALMOND);
        c3.setSize(Size.SMALL);
        c3.setPrice(CoffeePrice.SMALL_COST);
        c3.addFlavor(Flavor.CARAMEL);
        items.add(c3);

        CoffeeModel c4 = new CoffeeModel(image.getUrl());
        c4.setName("Fourth item");
        c4.setMilk(Dairy.SKIM);
        c4.setSize(Size.LARGE);
        c4.setPrice(CoffeePrice.LARGE_COST);
        items.add(c4);
        ConfirmListView.setItems(items);
        //end

        ConfirmListView.setCellFactory(new CoffeeCellFactory());
    }

    @FXML
    void ExitButtonClicked(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void MenuButtonClicked(ActionEvent event) throws IOException {
        SwitchToMainPage(event);
    }

    public void CancelButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Cancelled");
        DequeueItem();
        SwitchToMainPage(event);
    }

    public void ConfirmButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Confirmed");
        DequeueItem();
        SwitchToMainPage(event);
    }

    private void DequeueItem() {
        new Thread(() -> {
            //TODO: Dequeue item
            System.out.println("Item dequeued.");
        });
    }

    private void SwitchToMainPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainPage.class.getResource("main-page-view.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}

