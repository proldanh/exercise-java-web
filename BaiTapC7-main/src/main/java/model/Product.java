package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;

    public Product() {
        id = "";
        name = "";
        price = 0;
    }
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }
    public Product getProduct() {
        return this;
    }
}
