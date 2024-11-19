package model;

import java.io.Serializable;

public class DetailProduct implements Serializable {
    private Product product;
    private int quantity;

    public DetailProduct() {
        product = null;
        quantity = 0;
    }

    public DetailProduct(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
