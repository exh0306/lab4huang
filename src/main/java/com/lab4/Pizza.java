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

public class Pizza {
    private String type;
    private String size;
    private double price;

    // Constructor
    public Pizza(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    // Getters & Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}