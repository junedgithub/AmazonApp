package AmazonApp;

import java.util.*;

public class BLClass {
    static Map<String,String> data = new HashMap<>();

    static List<Product> products = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void addCustomer(Customer c)
    {
        Set<String> names =  data.keySet();
        if(data.isEmpty()){
            data.put(c.getName(),c.getPassword());
        }

        for (String n : names)
        {
            if (n.equals(c.getName()) && data.get(n).equals(c.getPassword()))
            {
                System.out.println("Login Successfully!!");
            }
            else if(n.equals(c.getName()) && !(data.get(n).equals(c.getPassword())))
            {
                System.out.println("Login Unsuccessfully!!");
            }
            else {
                data.put(c.getName(), c.getPassword());
                System.out.println("Customer Added Successfully!!");
            }
        }

    }

    public void addProducts(Product p)
    {
       products.add(p);
    }

    public void displayProduct() {
        for (Product p: products)
        {
            System.out.println(p);
        }

    }

    public void buyProduct(int productId, String productName) {
        for (Product p: products)
        {
            if (productId==p.getProductId() && productName.equals(p.getProductName()))
            {
                System.out.println("Product Price Is "+p.getProductPrice());
                System.out.println("1. Order Conform!!");
                System.out.println("2. Cancel!!");
                int ch = sc.nextInt();
                if (ch==1)
                {
                    System.out.println("Ordered Successfully!!");
                }else
                    System.out.println("Thank You visit Again!!");
            }
        }
    }

    public void cancelProduct(int id) {
        for(int i=0;i<products.size();i++)
        {
            if (id==products.get(i).getProductId())
            {
                products.remove(products.get(i));
            }
        }
    }

    public void displayProduct1(int id) {
        for (Product p: products)
        {
            if (id==p.getProductId())
            {
                System.out.println(p);
            }
        }
    }

}
