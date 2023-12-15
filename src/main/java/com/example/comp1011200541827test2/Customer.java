package com.example.comp1011200541827test2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customer {
    @SerializedName("id")
    private int customerId;
    private String firstName;
    private String lastName;
    private String city;
    private List<Purchase> purchases;

    public int getId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public String toString() {
        return String.format("Customer{id=%d, firstName='%s', lastName='%s', city='%s', purchases=%s}",
                customerId, firstName, lastName, city, purchases);
    }

    public double getPurchaseValue() {
        if (purchases != null) {
            return purchases.stream()
                    .mapToDouble(purchase -> purchase.getSalePrice())
                    .sum();
        }
        return 0.0; // or any default value you prefer if there are no purchases
    }
}
