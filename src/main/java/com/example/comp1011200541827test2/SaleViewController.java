package com.example.comp1011200541827test2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
    private TableColumn<Customer, List<Product>> purchasesColumn;  // Corrected type

    @FXML
    private Label retailPriceLabel;

    @FXML
    private Label salePriceLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private ListView<Product> listView;

    @FXML
    private TableView<Customer> tableView;

    private List<Customer> customers;


    @FXML
    void initialize() {
        //Populating the table view with the customers from the json file
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


        //Listener that will show the purchases made by the customer when the customer is selected
        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, customerSelected) ->
        {
            listView.getItems().clear();
            List<Product> courses = customerSelected.getPurchases();
            listView.getItems().addAll(courses);
        });


        //Updating the image view and labels when the product is selected from the list view
        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, productSelected) -> {
            listView.getItems().clear();
            List<Product> products = productSelected.getPurchases();
            listView.getItems().addAll(products);
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedProduct) -> {
            if (selectedProduct != null) {
                // Update labels and imageView based on selectedProduct
                updatePriceLabels(selectedProduct);
                updateImageView(selectedProduct);
            }
        });
    }

    private void updatePriceLabels(Product selectedProduct) {
        retailPriceLabel.setText("MSRP: $" + selectedProduct.getRegularPrice());
        salePriceLabel.setText("Sale Price: $" + selectedProduct.getSalePrice());
        savingsLabel.setText("Savings: $" + (selectedProduct.getRegularPrice() - selectedProduct.getSalePrice()));
    }

    private void updateImageView(Product selectedProduct) {
        //Loading image from the URL and set it to the imageView
        Image image = new Image(selectedProduct.getImage());
        imageView.setImage(image);
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
