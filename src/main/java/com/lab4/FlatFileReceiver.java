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

import java.io.BufferedReader;
import java.io.FileReader;

public class FlatFileReceiver {
    /**
     *
     * @param args command-line arguments
     * @throws Exception if file reading fails
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("pizza.txt"));
        String line = reader.readLine();
        reader.close();

        String[] parts = line.split(",");

        Pizza pizza = new Pizza(parts[0], parts[1], Double.parseDouble(parts[2]));

        System.out.println("Flat file received:");
        System.out.println("Type: " + pizza.getType());
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Price: $" + pizza.getPrice());
    }
}