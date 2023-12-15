package com.example.comp1011200541827test2;

import com.google.gson.annotations.SerializedName;

public class Purchase {
    @SerializedName("id")
    private int purchaseId;
    private String sku;
    private String name;
    private double salePrice;
    private double regularPrice;
    private String image;

    public int getId() {
        return purchaseId;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public String getImage() {
        return image;
    }

    public String toString() {
        return String.format("%d sku: %s", purchaseId, sku);
    }
}
