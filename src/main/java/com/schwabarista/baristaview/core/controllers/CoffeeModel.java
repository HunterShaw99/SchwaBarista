package com.schwabarista.baristaview.core.controllers;

import com.schwabarista.baristaview.core.controllers.Dairy;
import com.schwabarista.baristaview.core.controllers.Flavor;
import com.schwabarista.baristaview.core.controllers.Dairy;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//each coffee model will have: a name, the chosen size, the chosen milk, the chosen flavors,
//                            the total price, and the prices per size.
public class CoffeeModel implements Serializable {

    public UUID itemID;
    public String name;
    public Size size;
    public Dairy milk;
    public List<Flavor> flavors;
    public BigDecimal price;
    public String image;

    public CoffeeModel() {
        itemID = UUID.randomUUID();
        this.price = BigDecimal.ZERO;
        this.flavors = new ArrayList<Flavor>();
    }

    public CoffeeModel(String imageURL, BigDecimal price) {
        itemID = UUID.randomUUID();
        image = imageURL;
        this.price = price;
        this.flavors = new ArrayList<Flavor>();
    }

    public UUID getItemID() {
        return this.itemID;
    }

    public String toString() {
        return name+" Price:"+price.toString()+" Flavors:"+flavors.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setMilk(Dairy milk) {
        this.milk = milk;
    }

    public Dairy getMilk() {
        return milk;
    }

    public String getMilkValue() {
        return milk.getDairy();
    }

    public ArrayList<Flavor> getFlavors() {
        ArrayList<Flavor> f = new ArrayList<>(flavors);
        return f;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void addFlavor(Flavor flavor) {
        flavors.add(flavor);
    }

    public void removeFlavor(Flavor flavor) {
        flavors.remove(flavor);
    }

    public String getImage() {
        return image;
    }
}
