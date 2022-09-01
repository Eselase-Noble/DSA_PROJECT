package com.example.g22dsainventorysystem.structures;

public class Vendors {


  private int Vendor_ID;
  private String Vendor_Name, Email,PhoneNumber,Location,Address;
  public Vendors(int Vendor_ID, String Vendor_Name, String PhoneNumber, String Email, String Location, String Address){
      this.Vendor_ID= Vendor_ID;
      this.Vendor_Name =  Vendor_Name;
      this.PhoneNumber = PhoneNumber;
      this.Email = Email;
      this.Location = Location;
      this.Address = Address;
  }

    public int getVendor_ID() {
        return Vendor_ID;
    }

    public void setVendor_ID(int vendor_ID) {
        Vendor_ID = vendor_ID;
    }

    public String getVendor_Name() {
        return Vendor_Name;
    }

    public void setVendor_Name(String vendor_Name) {
        Vendor_Name = vendor_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getLocation() {
        return Location;
    }

}
