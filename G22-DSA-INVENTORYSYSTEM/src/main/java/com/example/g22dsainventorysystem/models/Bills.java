package com.example.g22dsainventorysystem.models;

public class Bills {
    private Integer Bill_ID;
    private String Payment_Type;
    private Double TotalAmount;
    private java.util.Date Date;
    private Integer Issued_ID;

    private  String Product_Name;

    private String Vendor_Name;
    IssuedGoods issuedGoods = new IssuedGoods();
    public Bills(){}

    public Bills(int Bill_ID, String paymentType, Double totalAmount, java.util.Date date, int issued_ID, String product_Name, String Vendor_Name){
        this.Bill_ID = Bill_ID;
        this.Payment_Type = paymentType;
        this.TotalAmount = totalAmount;
        this.Date = date;
        this.Issued_ID = issued_ID ;
        this.Product_Name = product_Name;
        this.Vendor_Name = Vendor_Name;

    }

    public Integer getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(Integer bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getPaymentType() {
        return Payment_Type;
    }

    public void setPaymentType(String paymentType) {
        Payment_Type = paymentType;
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

    public Integer getIssued_ID() {
        return Issued_ID;
    }

    public void setIssued_ID(Integer issued_ID) {
        Issued_ID = issued_ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getVendor_Name() {
        return Vendor_Name;
    }

    public void setVendor_Name(String vendor_Name) {
        Vendor_Name = vendor_Name;
    }
}
