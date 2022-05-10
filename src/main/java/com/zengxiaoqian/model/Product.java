package com.zengxiaoqian.model;

import java.io.InputStream;

public class Product {
    private  int productid;
    private  String productname;
    private String productdescription;
    private InputStream picture;
    private double price;
    private int categoryid;

    public Product(){}

    public Product(int productid, String productname, String productdescription, InputStream picture, double price, int categoryid) {
        this.productid = productid;
        this.productname = productname;
        this.productdescription = productdescription;
        this.picture = picture;
        this.price = price;
        this.categoryid = categoryid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productdescription='" + productdescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryid=" + categoryid +
                '}';
    }
}
