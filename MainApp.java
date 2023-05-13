package AmazonApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static Customer c;
    static List<Product> products = new ArrayList<>();

    static BLClass b = new BLClass();
    static{
        for (int i=0;i<3;i++) {
            addProduct();
        }
        displayProduct();
    }

    public static void main(String[] args) {
        boolean status = true;
        do {
            System.out.println("=========================");
            System.out.println("1. Buy Products!!");
            System.out.println("2. Cancel Products!!");
            System.out.println("3. Display Product!!");
            System.out.println("4. Sign Out!!");
            System.out.println("5. Exit!!");
            System.out.println("==================================");
            int ch = sc.nextInt();
            if (c == null) {
                c = login();
            }
            switch (ch) {
                case 1:
                    buyProduct();
                    break;
                case 2:
                   cancelProduct();
                    break;
                case 3:
                    displayProduct1();
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    status=false;
                    break;
                default:
                    System.out.println("Invalid Choice!!");

            }
        } while (status);
    }

    private static void displayProduct1() {
        System.out.println("Enter ProductId of Product to Buy!!");
        int id = sc.nextInt();
        b.displayProduct1(id);
    }

    private static void displayProduct() {
        b.displayProduct();
    }

    private static void cancelProduct() {
        System.out.println("Enter ProductId to be Cancelled!!");
        int id = sc.nextInt();
        b.cancelProduct(id);
        System.out.println("Cancelled Successfully!!");
    }

    private static void buyProduct() {
        System.out.println("Enter Product Id");
        int productId = sc.nextInt();
        System.out.println("Enter Product Name");
        String productName = sc.next();
        b.buyProduct(productId,productName);
    }

    public static Customer login() {
        System.out.println("Enter Username");
        String username = sc.next();
        System.out.println("Enter Password");
        String password = sc.next();
        Customer c = new Customer(username, password);
        b.addCustomer(c);
        return c;
    }

    public static Product addProduct() {
        boolean status = true;
        Product p = null;
        do {
            System.out.println("1. Add Product!!");
            System.out.println("2. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter ProductId");
                    int productId = sc.nextInt();
                    System.out.println("Enter ProductName");
                    String productName = sc.next();
                    System.out.println("Enter ProductPrice");
                    double productPrice = sc.nextDouble();
                    p = new Product(productId, productName, productPrice);
                    b.addProducts(p);
                    System.out.println("Product Added Successfully!!");

                case 2:
                    status = false;
            }

        } while (status);
        return p;
    }

}
