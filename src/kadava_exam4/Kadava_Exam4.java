/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kadava_exam4;

import java.util.Scanner;

class Product {
    private String product;
    private int quantity;

    public Product(String product, int quantity) {
        this.product = product;
        this.quantity = quantity ;
    }

    public String getName() {
        return product;
    }

    public int getquantity() {
        return quantity;
    }


    public String toString() {
        return "Product:" + product + ", Quantity: " + quantity ;
    }
}

class Stack {
    private int maxSize;
    private Product[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new Product[size];
        top = 1;
    }

    public void add(Product product) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot add.");
            return;
        }
        stackArray[++top] = product;
    }

    public Product delete() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot delete.");
            
        }
        return stackArray[top--];
    }
public void display()throws Exception{
     if (top == 0){
         throw new Exception("Stack Empty");
     }
     
     for (int i = top ; i > 0; i--){
         System.out.println(stackArray[i]+"*******");
     }
     System.out.println("NULL");
     
     
}
    public Product peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == 1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}

public class Kadava_Exam4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the product to stack: ");
        int maxSize = scanner.nextInt();
        Stack Stacks = new Stack(maxSize);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. AddProduct");
            System.out.println("2. sellProduct");
            System.out.println("3. display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();  
                    System.out.print("Enter Product: ");
                    String product = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Stacks.add(new Product(product, quantity));
                    break;
                case 2:
                    Product Delete = Stacks.delete();
                    if (Delete != null) {
                        System.out.println("SellPRODUCT: " + Delete);
                    }
                    break;
                case 3:
                  Stacks.display();
                  break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
