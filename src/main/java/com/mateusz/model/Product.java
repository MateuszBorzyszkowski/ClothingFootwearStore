package com.mateusz.model;

public class Product {

    public final static String PRODUCT_SEPARATOR = "#";

    private int id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;

    public Product(int id, String productName, float price, float weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    // Setters
    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR +
                productName + PRODUCT_SEPARATOR +
                price + PRODUCT_SEPARATOR +
                weight + PRODUCT_SEPARATOR +
                color + PRODUCT_SEPARATOR +
                productCount;
    }
}
