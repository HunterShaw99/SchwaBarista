package com.schwabarista.baristaview.core.controllers;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderModel implements Serializable {

    public BigDecimal orderTotal;
    public List<CoffeeModel> beverageLIST;
    public String orderID;
    public OrderStatus orderStatus;//Order Status is either {PROCESSING, DONE, CANCELLED}

    public OrderModel() {

    }

    public OrderModel(BigDecimal orderTotal, ObservableList<CoffeeModel> beverageLIST, OrderStatus orderStatus) {
        this.orderTotal = orderTotal;
        this.beverageLIST = beverageLIST;
        orderID = UUID.randomUUID().toString().substring(0,11);
        this.orderStatus = orderStatus;
    }

    public BigDecimal Get_OrderTotal() {
        return orderTotal;
    }

    public List<CoffeeModel> GetBeverageList() {
        return beverageLIST;
    }

    public String GetOrderID() {
        return orderID;
    }

    public OrderStatus GetOrderStatus() {
        return orderStatus;
    }

    public void SetOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
