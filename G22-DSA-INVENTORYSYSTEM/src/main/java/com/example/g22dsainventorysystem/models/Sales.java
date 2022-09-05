package com.example.g22dsainventorysystem.models;

import com.example.g22dsainventorysystem.structures.Vendors;

import java.util.Date;

public class Sales {

    private  Integer sales_ID;
    private Integer Bill_ID;
    private Integer Vendor_ID;
    private Date date;
    Bills bills = new Bills();
    Vendors vendors = new Vendors();
    public Sales(){}

    public Sales( int bill_ID, int Vendor_ID, Date date){
        bill_ID = bills.getBill_ID();
        this.Bill_ID = bill_ID;
        Vendor_ID = vendors.getVendor_ID();
        this.Vendor_ID = Vendor_ID;
        this.date = date;

    }

    public Integer getSales_ID() {
        return sales_ID;
    }

    public void setSales_ID(Integer sales_ID) {
        this.sales_ID = sales_ID;
    }

    public Integer getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(Integer bill_ID) {
        Bill_ID = bill_ID;
    }

    public Integer getVendor_ID() {
        return Vendor_ID;
    }

    public void setVendor_ID(Integer vendor_ID) {
        Vendor_ID = vendor_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
