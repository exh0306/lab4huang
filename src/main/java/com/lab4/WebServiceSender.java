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

import org.springframework.web.client.RestTemplate;
public class WebServiceSender {

    /**
     * Main method to send a Pizza object to the web service receiver.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Pizza pizza = new Pizza("Pepperoni", "Large", 14.99);

        String response = restTemplate.postForObject(
                "http://localhost:8080/pizza",
                pizza,
                String.class
        );

        System.out.println("Server response: " + response);
    }
}