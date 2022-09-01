package com.example.g22dsainventorysystem.structures;

public class Category {
    private  Integer Category_ID;
    private  String Category_Name;
    private  String Description;

    public Category(){}

    public Category(Integer Category_ID,String Category_Name, String Description){
        this.Category_ID = Category_ID;
        this.Category_Name = Category_Name;
        this.Description = Description;
    }

    public Integer getCategory_ID() {
        return Category_ID;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setCategory_ID(Integer category_ID) {
        Category_ID = category_ID;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
