package com.java.ecom.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.ecom.dao.CustomerDao;
import com.java.ecom.dao.CustomerDaoImpl;
import com.java.ecom.dao.ProductDao;
import com.java.ecom.dao.ProductDaoImpl;
import com.java.ecom.dao.CartDao;
import com.java.ecom.dao.CartDaoImpl;
import com.java.ecom.model.Customer;
import com.java.ecom.model.Gender;
import com.java.ecom.model.Product;
import com.java.ecom.model.Cart;

public class EcomMain {

    static Scanner sc = new Scanner(System.in);
    static CustomerDao customerDao = new CustomerDaoImpl();
    static ProductDao productDao = new ProductDaoImpl();
    static CartDao cartDao = new CartDaoImpl();

    public static void customerShow() throws ClassNotFoundException, SQLException {
        List<Customer> customerList = customerDao.showCustomerDao();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public static void searchCustomer() throws ClassNotFoundException, SQLException {
        int customerId;
        System.out.println("Enter Customer Id ");
        customerId = sc.nextInt();
        Customer customer = customerDao.searchByCustomerId(customerId);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("*** Customer Record Not Found ***");
        }
    }

    public static void searchCustomerByUsername() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Customer Username (Email): ");
        sc.nextLine();
        String email = sc.nextLine();

        Customer customer = customerDao.searchByCustomerUsername(email);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("*** Customer Record Not Found ***");
        }
    }

    public static void authenticateCustomer() throws ClassNotFoundException, SQLException {
        sc.nextLine();
        System.out.println("Enter Customer Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Customer Password: ");
        String password = sc.nextLine();

        int c = customerDao.authenticate(email, password);
        if (c > 0) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Invalid email or password.");
        }
    }

    public static void addCustomer() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Customer Details:");

        String firstName, lastName, email, password, phone, address, city, state, postalCode, country;
        Gender gender;
        sc.nextLine();
        System.out.print("First Name: ");
        firstName = sc.nextLine();
        System.out.print("Last Name: ");
        lastName = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        System.out.print("Phone: ");
        phone = sc.nextLine();

        System.out.print("Gender (Male/Female): ");
        String genderStr = sc.nextLine();
        gender = Gender.valueOf(genderStr);

        System.out.print("Address: ");
        address = sc.nextLine();
        System.out.print("City: ");
        city = sc.nextLine();
        System.out.print("State: ");
        state = sc.nextLine();
        System.out.print("Postal Code: ");
        postalCode = sc.nextLine();
        System.out.print("Country: ");
        country = sc.nextLine();
        
        Customer customer = new Customer(firstName, lastName, email, password, phone, gender, address, city, state, postalCode, country);

        int rowsAffected = customerDao.addCustomer(customer);
        if (rowsAffected > 0) {
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Failed to add customer. Please try again.");
        }
    }

    public static void productShow() throws ClassNotFoundException, SQLException {
        List<Product> productList = productDao.showProducts();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void searchProductById() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Product ID: ");
        int productId = sc.nextInt();

        Product product = productDao.searchByProductId(productId);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("*** Product Record Not Found ***");
        }
    }

    public static void addProduct() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Product Details:");

        String productName, description;
        double price;
        int quantity;

        sc.nextLine();
        System.out.print("Product Name: ");
        productName = sc.nextLine();
        System.out.print("Description: ");
        description = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextDouble();
        System.out.print("Quantity: ");
        quantity = sc.nextInt();

        Product product = new Product(productName, price, description, quantity);

        int rowsAffected = productDao.addProduct(product);
        if (rowsAffected > 0) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product. Please try again.");
        }
    }

    public static void viewCartByCartId() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Cart ID: ");
        int cartId = sc.nextInt();

        Cart cart = cartDao.searchByCartId(cartId);
        if (cart != null) {
            System.out.println(cart);
        } else {
            System.out.println("*** No product found for the given Cart ID ***");
        }
    }

    public static void addToCart() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Cart Details:");

        int customerId, productId, quantity;

        System.out.print("Customer ID: ");
        customerId = sc.nextInt();
        System.out.print("Product ID: ");
        productId = sc.nextInt();
        System.out.print("Quantity: ");
        quantity = sc.nextInt();

        Cart cart = new Cart(customerId, productId, quantity);

        int rowsAffected = cartDao.addToCart(cart);
        if (rowsAffected > 0) {
            System.out.println("Product added to cart successfully!");
        } else {
            System.out.println("Failed to add product to cart. Please try again.");
        }
    }

    public static void updateCart() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Cart ID and Updated Quantity:");

        int cartId, quantity;

        System.out.print("Cart ID: ");
        cartId = sc.nextInt();
        System.out.print("Updated Quantity: ");
        quantity = sc.nextInt();

        Cart cart = new Cart(cartId, quantity);

        int rowsAffected = cartDao.updateCart(cart);
        if (rowsAffected > 0) {
            System.out.println("Cart updated successfully!");
        } else {
            System.out.println("Failed to update cart. Please try again.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Customer Show");
            System.out.println("2. Customer Search by ID");
            System.out.println("3. Customer Search by Email");
            System.out.println("4. Customer Authentication");
            System.out.println("5. Add Customer");
            System.out.println("6. Product Show");
            System.out.println("7. Search Product by ID");
            System.out.println("8. Add Product");
            System.out.println("9. View Cart by Cart ID");
            System.out.println("10. Add Product to Cart");
            System.out.println("11. Update Cart");
            System.out.println("Enter Your Choice ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        customerShow();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        searchCustomer();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        searchCustomerByUsername();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        authenticateCustomer();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        addCustomer();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        productShow();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        searchProductById();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        addProduct();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        viewCartByCartId();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    try {
                        addToCart();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    try {
                        updateCart();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 0);
    }
}
