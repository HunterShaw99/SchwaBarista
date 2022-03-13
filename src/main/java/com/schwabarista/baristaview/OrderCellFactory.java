package com.schwabarista.baristaview;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

    public class OrderCellFactory implements Callback<ListView<OrderModel>, ListCell<OrderModel>> {

        @Override
        public ListCell<OrderModel> call(ListView<OrderModel> param) {
            return new OrderCell();
        }
    }
