package icetask_3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ICETask_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //calling a new import 
        //this format helps create decimals that can be rounded up
        DecimalFormat dec = new DecimalFormat("###.##");
        //declaring a new scanner 
        Scanner scan = new Scanner(System.in);
        //prompting user for information 
        System.out.println("Enter product name >> ");
        String goodsItem = scan.nextLine();
        
        System.out.println("Enter price of the LCD TV >> ");
        double goodsPrice = scan.nextDouble();
        //calling the method product to be executed 
        Product product = new Product(goodsItem, goodsPrice);
        //displaying the user information 
        System.out.println("Product >> " + product.getProductName());
        System.out.println("Price >> R" + dec.format(product.calculatePrice()));
        
    }

    //creating a new method to store the variables 
    public static class Product {
        //alt insert for getter and setter 
        //Declaring the variables
        String productName;
        double productPrice;

        //creating a constructor class 
        public Product(String name, double price) {//storage
            this.productName = name;
            this.productPrice = price;

        }
        //getters and setters
        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public Product() {
        }

        //can only have one constructor class and therefore this is another method within the product class 
        public double calculatePrice() {
            
            //decalring the calculations needed for the final price 
            double VAT = productPrice * 0.14;
            double totalDue = productPrice + VAT;
            //creating an if statement to follow the condition 
            if (totalDue >= 10000) {
                totalDue= totalDue -(totalDue*0.05);
            }
            //returning the the value 
            return totalDue;
        }
    }

}
