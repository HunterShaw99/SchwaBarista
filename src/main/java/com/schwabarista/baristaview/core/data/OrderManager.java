package com.schwabarista.baristaview.core.data;

import com.schwabarista.baristaview.models.CoffeeModel;
import com.schwabarista.baristaview.models.OrderModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import java.util.UUID;


public class OrderManager {

    private volatile static OrderManager instance = null;
    private static OrderModel currentItem;
    private static ObservableList<OrderModel> itemList;

    private OrderManager() {
        itemList = FXCollections.observableArrayList();
    }

    public static OrderManager GetInstance() {
        if (instance == null) {
            synchronized (OrderManager.class) {
                if (instance == null) {
                    instance = new OrderManager();
                }
            }
        }
        return instance;
    }

    public OrderModel GetCurrentItem() {
        return currentItem;
    }

    public void SetCurrentItem(OrderModel m) {
        currentItem = m;
    }

    public ObservableList<OrderModel> GetItemList() {
        return itemList;
    }

    public void SetItemList(ObservableList<OrderModel> itemList) {
        OrderManager.itemList = itemList;
    }

    public void AddItem(OrderModel m) {
        itemList.add(m);
    }

    public void RemoveItem(OrderModel m) {
        if (itemList.contains(m)) itemList.remove(m);
    }

    public void RemoveCurrentItem() {
        RemoveItem(GetCurrentItem());
    }

}
