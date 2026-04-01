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
import org.springframework.web.bind.annotation.*;

@RestController
public class WebServiceReceiver {

    /**
     * Receives a Pizza object as JSON from a POST request and prints it.
     *
     * @param pizza the Pizza object received from the sender
     * @return confirmation message
     */
    @PostMapping("/pizza")
    public String receivePizza(@RequestBody Pizza pizza) {
        System.out.println("Web service received:");
        System.out.println("Type: " + pizza.getType());
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Price: $" + pizza.getPrice());

        return "Pizza received successfully";
    }
}
