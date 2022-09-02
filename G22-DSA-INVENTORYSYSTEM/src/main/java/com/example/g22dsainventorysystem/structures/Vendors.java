package com.example.g22dsainventorysystem.structures;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vendors {


  private Integer Vendor_ID  ;
  private String Vendor_Name ;

  private String  Email ;
  private String PhoneNumber;
  private String Location;

  private String Address ;
  public Vendors(){}
  public Vendors(Integer Vendor_ID, String Vendor_Name, String PhoneNumber, String Email, String Location, String Address){
      this.Vendor_ID = Vendor_ID;
      this.Vendor_Name = Vendor_Name;
      this.PhoneNumber = PhoneNumber;
      this.Email = Email;
      this.Location  = Location;
      this.Address = Address;
//      this.Vendor_ID = new   SimpleIntegerProperty(Vendor_ID);
//      this.Vendor_Name = new SimpleStringProperty(Vendor_Name);
//      this.PhoneNumber = new SimpleStringProperty(PhoneNumber);
//      this.Email = new SimpleStringProperty(Email);
//      this.Location = new SimpleStringProperty(Location);
//      this.Address = new SimpleStringProperty(Address);
  }



    public Integer getVendor_ID() {
        return Vendor_ID;
    }

    public void setVendor_ID(int vendor_ID) {
        Vendor_ID = vendor_ID;
    }

    public String getVendor_Name() {
        return Vendor_Name;
    }

    public void setVendor_Name(String vendor_Name) {
        Vendor_Name= vendor_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
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

    public Map<String, StringProperty> fields;

    public Vendors(Map<String, String> record)
    {
        this.fields = new HashMap<>();
        for (String key : record.keySet())
        {
            this.fields.put(key, new SimpleStringProperty());
        }
        for (Map.Entry<String, String> entry : ((Set<Map.Entry<String, String>>) record.entrySet()))
        {

            this.fields.get(entry.getKey()).set(entry.getValue());
        }
    }

    public final StringProperty fieldProperty(String key)
    {
        return this.fields.get(key);
    }

}
