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

import com.rabbitmq.client.*;
import com.google.gson.Gson;

public class RabbitReceiver {

    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("Waiting for messages...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());

            // Convert JSON back to Pizza
            Gson gson = new Gson();
            Pizza pizza = gson.fromJson(message, Pizza.class);

            System.out.println("Received Pizza:");
            System.out.println(pizza.getType() + " " + pizza.getSize() + " $" + pizza.getPrice());
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
