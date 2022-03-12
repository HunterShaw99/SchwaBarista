package com.schwabarista.baristaview.core.controllers;

//import com.schwa.schwacoffe.core.data.CartManager;
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

public class HelloController {

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
        //switch scenes
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
//        root = loader.load();
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
    }
}

