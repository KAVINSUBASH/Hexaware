package com.java.ecom.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.ecom.dao.CustomerDao;
import com.java.ecom.dao.CustomerDaoImpl;
import com.java.ecom.dao.OrderItemsDao;
import com.java.ecom.dao.OrderItemsDaoImpl;
import com.java.ecom.dao.OrdersDao;
import com.java.ecom.dao.OrdersDaoImpl;
import com.java.ecom.dao.PaymentsDao;
import com.java.ecom.dao.PaymentsDaoImpl;
import com.java.ecom.dao.ProductDao;
import com.java.ecom.dao.ProductDaoImpl;
import com.java.ecom.dao.CartDao;
import com.java.ecom.dao.CartDaoImpl;
import com.java.ecom.model.Customer;
import com.java.ecom.model.Gender;
import com.java.ecom.model.OrderItems;
import com.java.ecom.model.Orders;
import com.java.ecom.model.Payments;
import com.java.ecom.model.Product;
import com.java.ecom.model.Cart;
import com.java.ecom.model.Orders;

public class EcomMain {

    static Scanner sc = new Scanner(System.in);
    static CustomerDao customerDao = new CustomerDaoImpl();
    static ProductDao productDao = new ProductDaoImpl();
    static CartDao cartDao = new CartDaoImpl();
    static OrdersDao ordersDao = new OrdersDaoImpl();
    static OrderItemsDao orderItemsDao = new OrderItemsDaoImpl();
    static PaymentsDao paymentsDao = new PaymentsDaoImpl();

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
    
    public static void showOrders() throws ClassNotFoundException, SQLException {
        List<Orders> ordersList = ordersDao.showOrdersDao();
        for (Orders order : ordersList) {
            System.out.println(order);
        }
    }

    public static void showOrdersMoreThan() throws ClassNotFoundException, SQLException {
        List<Orders> ordersList = ordersDao.showOrdersMoreThanDao();
        for (Orders order : ordersList) {
            System.out.println(order);
        }
    }

    public static void showOrderItems() throws ClassNotFoundException, SQLException {
        List<OrderItems> orderItemsList = orderItemsDao.showOrderItemsDao();
        for (OrderItems orderItem : orderItemsList) {
            System.out.println(orderItem);
        }
    }
    public static void showPaymentDetailsByOrderId() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Order ID: ");
        int orderId = sc.nextInt();

        Payments payment = paymentsDao.showPaymentDetailsByOrderId(orderId);
        if (payment != null) {
            System.out.println(payment);
        } else {
            System.out.println("*** No Payment Details Found ***");
        }
    }

    public static void showPaymentDetailsById() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Payment ID: ");
        int paymentId = sc.nextInt();

        Payments payment = paymentsDao.showPaymentDetailsById(paymentId);
        if (payment != null) {
            System.out.println(payment);
        } else {
            System.out.println("*** No Payment Details Found ***");
        }
    }

    public static void addPayment() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Payment Details:");

        System.out.print("Order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();
        System.out.print("Payment Method: ");
        String paymentMethod = sc.nextLine();
        System.out.print("Transaction ID: ");
        String transactionId = sc.nextLine();
        System.out.print("Payment Status: ");
        String paymentStatus = sc.nextLine();

        Payments payment = new Payments();
        payment.setOrderId(orderId);
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionId(transactionId);
        payment.setPaymentStatus(paymentStatus);

        boolean success = paymentsDao.addPayment(payment);
        if (success) {
            System.out.println("Payment added successfully!");
        } else {
            System.out.println("Failed to add payment. Please try again.");
        }
    }

    public static void updatePayment() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Updated Payment Details:");

        System.out.print("Payment ID: ");
        int paymentId = sc.nextInt();
        sc.nextLine();
        System.out.print("Updated Payment Method: ");
        String paymentMethod = sc.nextLine();
        System.out.print("Updated Transaction ID: ");
        String transactionId = sc.nextLine();
        System.out.print("Updated Payment Status: ");
        String paymentStatus = sc.nextLine();

        Payments payment = new Payments();
        payment.setPaymentId(paymentId);
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionId(transactionId);
        payment.setPaymentStatus(paymentStatus);

        boolean success = paymentsDao.updatePayment(payment);
        if (success) {
            System.out.println("Payment updated successfully!");
        } else {
            System.out.println("Failed to update payment. Please try again.");
        }
    }

    public static void showAllPendingPayments() throws ClassNotFoundException, SQLException {
        List<Payments> pendingPayments = paymentsDao.showAllPendingPayments();
        for (Payments payment : pendingPayments) {
            System.out.println(payment);
        }
    }

    public static void showAllCompletedPayments() throws ClassNotFoundException, SQLException {
        List<Payments> completedPayments = paymentsDao.showAllCompletedPayments();
        for (Payments payment : completedPayments) {
            System.out.println(payment);
        }
    }
    
    public static void placeAnOrder() throws ClassNotFoundException, SQLException {
        Orders order = new Orders();
        System.out.println("Enter Order Details:");
        System.out.print("Customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine();
        System.out.print("Total Price: ");
        double totalPrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Shipping Address: ");
        String shippingAddress = sc.nextLine();
        order.setCustomerId(customerId);
        order.setTotalPrice(totalPrice);
        order.setShippingAddress(shippingAddress);
        boolean success = ordersDao.placeOrder(order);
        if (success) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Failed to place the order.");
        }
    }
    public static void displayOrderItemsByProduct() throws ClassNotFoundException, SQLException {
        System.out.print("Enter Product ID to view associated Order Items: ");
        int productId = sc.nextInt();
        sc.nextLine();
        List<OrderItems> orderItemsList = orderItemsDao.showOrderItemsByProduct(productId);
        if (orderItemsList.isEmpty()) {
            System.out.println("No order items found for the given Product ID.");
        } else {
            System.out.println("Order Items for Product ID: " + productId);
            for (OrderItems item : orderItemsList) {
                System.out.println("Order Item ID: " + item.getOrderItemId() +", Order ID: " + item.getOrderId() +", Quantity: " + item.getQuantity());
            }
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
            System.out.println("12. Show Orders");
            System.out.println("13. Show Orders with Price > 100");
            System.out.println("14. Show Order Items");
            System.out.println("15. Show Payment Details by Order ID");
            System.out.println("16. Show Payment Details by Payment ID");
            System.out.println("17. Add Payment");
            System.out.println("18. Update Payment");
            System.out.println("19. Show All Pending Payments");
            System.out.println("20. Show All Completed Payments");
            System.out.println("21. Place an Order");
            System.out.println("22. Show Order Items by Product");
            
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
                case 12:
                    try {
                        showOrders();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 13:
                    try {
                        showOrdersMoreThan();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 14:
                    try {
                        showOrderItems();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 15:
                    try {
                        showPaymentDetailsByOrderId();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 16:
                    try {
                        showPaymentDetailsById();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 17:
                    try {
                        addPayment();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 18:
                    try {
                        updatePayment();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 19:
                    try {
                        showAllPendingPayments();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 20:
                    try {
                        showAllCompletedPayments();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 21:
                    try {
                        placeAnOrder();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 22:
                    try {
                        displayOrderItemsByProduct();
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
