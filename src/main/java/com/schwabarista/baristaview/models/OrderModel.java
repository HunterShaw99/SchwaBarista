package com.schwabarista.baristaview.models;

import com.schwabarista.baristaview.models.constants.OrderStatus;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import java.util.UUID;

public class OrderModel {

    private final BigDecimal orderTotal;
    private ObservableList<CoffeeModel> beverageLIST;
    private final String orderID;
    private OrderStatus orderStatus;//Order Status is either {PROCESSING, DONE, CANCELLED}
    private String pickupTime;

    public OrderModel(BigDecimal orderTotal, ObservableList<CoffeeModel> beverageLIST, OrderStatus orderStatus) {
        this.orderTotal = orderTotal;
        this.beverageLIST = beverageLIST;
        orderID = UUID.randomUUID().toString().substring(0,11);
        this.orderStatus = orderStatus;
    }

    public BigDecimal Get_OrderTotal() {return orderTotal;}

    public ObservableList<CoffeeModel> GetBeverageList() {
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

    public String GetPickupTime() {
        return pickupTime;
    }

    public void SetPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
}
