package com.example.g22dsainventorysystem.models;

import com.example.g22dsainventorysystem.structures.Product;

import java.util.Date;

public class IssuedGoods {
    private Integer Issued_ID;
    private Integer Quantity;
    private Integer Product_ID;
    private Double Selling_Price;
    private Double TotalAmount;
    private Date Date;
    Product product = new Product();
    public IssuedGoods(){}

    public IssuedGoods(int Issued_ID, int quantity, int product_ID, Double selling_Price, double totalAmount, Date date){

    this.Issued_ID= Issued_ID;
    this.Quantity =  quantity;
    product_ID = product.getProduct_ID();
    this.Product_ID = product_ID;
    this.Selling_Price = selling_Price;
    this.TotalAmount = totalAmount;
    this.Date = date;
    }

    public Integer getIssued_ID() {
        return Issued_ID;
    }

    public void setIssued_ID(Integer issued_ID) {
        Issued_ID = issued_ID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        Product_ID = product_ID;
    }

    public Double getSelling_Price() {
        return Selling_Price;
    }

    public void setSelling_Price(Double selling_Price) {
        Selling_Price = selling_Price;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
