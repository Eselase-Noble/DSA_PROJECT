package com.example.g22dsainventorysystem.models;

public class Bills {
    private Integer Bill_ID;
    private String PaymentType;
    private Double TotalAmount;
    private java.util.Date Date;
    private Integer Issued_ID;
    IssuedGoods issuedGoods = new IssuedGoods();
    public Bills(){}

    public Bills(int Bill_ID, String paymentType, Double totalAmount, java.util.Date date, int issued_ID){
        this.Bill_ID = Bill_ID;
        this.PaymentType = paymentType;
        this.TotalAmount = totalAmount;
        this.Date = date;
        issued_ID = issuedGoods.getIssued_ID();
        this.Issued_ID = issued_ID ;

    }

    public Integer getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(Integer bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
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


}
