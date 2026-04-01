/**

 * Project: Lab 4
 * Purpose Details: Represents a Pizza object
 * Course : IST 242
 * Author: Emlety Huang
 * Date Developed: 3/26/26
 * Last Date Changed: 3/31/26
 * Revision: 3/31/26
 *
 */
package com.lab4;

import java.io.FileWriter;
public class FlatFileSender {

    /**
     * Main method to create a Pizza object
     *
     * @param args command-line arguments
     * @throws Exception if file writing fails
     */
    public static void main(String[] args) throws Exception {
        Pizza pizza = new Pizza("Cheese", "Medium", 10.99);

        String data = pizza.getType() + "," + pizza.getSize() + "," + pizza.getPrice();

        FileWriter writer = new FileWriter("pizza.txt");
        writer.write(data);
        writer.close();

        System.out.println("Flat file sent: " + data);
    }
}