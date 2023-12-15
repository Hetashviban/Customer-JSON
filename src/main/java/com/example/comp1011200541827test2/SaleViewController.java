package com.example.comp1011200541827test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.util.List;

public class SaleViewController {

    @FXML
    private TableColumn<Customer, String> cityColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private ImageView imageView;

    @FXML
    private Label label;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, List<Purchase>> purchasesColumn;  // Corrected type

    @FXML
    private Label retailPriceLabel;

    @FXML
    private Label salePriceLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private ListView<Purchase> listView;

    @FXML
    private TableView<Customer> tableView;

    private List<Customer> customers;


    @FXML
    void initialize() {
        Business business = JsonUtility.getBusinessFromFile("customers.json");
        if (business != null) {
            customers = business.getCustomers();
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            purchasesColumn.setCellValueFactory(new PropertyValueFactory<>("formattedPurchaseValue"));
            tableView.getItems().addAll(customers);
            updateLabels();
        }
    }

    private void updateLabels()
    {
        label.setText("Number of Customers: " + tableView.getItems().size());
    }

    @FXML
    void allCustomersButton(ActionEvent event) {
        // Handle all customers button action
    }

    @FXML
    void savedMoneyButton(ActionEvent event) {
        // Handle saved money button action
    }
}
