package com.example.comp1011200541827test2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Buisness {
    @SerializedName("BusinessName")
    private String businessName;
    @SerializedName("Customers")
    private List<Customer> customers;

    public String getBusinessName() {
        return businessName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String toString() {
        return String.format("Business{businessName='%s', customers=%s}", businessName, customers);
    }
}
