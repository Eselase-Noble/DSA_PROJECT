package com.example.g22dsainventorysystem.structures;

public class Product {

    private Integer Product_ID;
    private String Product_Name;
    private Double Selling_Price;
    private Integer Quantity;
    private Integer Category_ID;
    private String Product_Code;
    public String Category_Name;

    public Integer getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        Product_ID = product_ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public Double getSelling_Price() {
        return Selling_Price;
    }

    public void setSelling_Price(Double selling_Price) {
        Selling_Price = selling_Price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(Integer category_ID) {
        Category_ID = category_ID;
    }

    public String getProduct_Code() {
        return Product_Code;
    }

    public void setProduct_Code(String product_Code) {
        Product_Code = product_Code;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product_ID=" + Product_ID +
                ", Product_Name='" + Product_Name + '\'' +
                ", Selling_Price=" + Selling_Price +
                ", Quantity=" + Quantity +
                ", Category_ID=" + Category_ID +
                ", Product_Code='" + Product_Code + '\'' +
                ", Category_Name='" + Category_Name + '\'' +
                '}';
    }
}
