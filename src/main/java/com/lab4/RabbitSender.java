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

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.google.gson.Gson;

public class RabbitSender {

    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            Pizza pizza = new Pizza("Sausage", "Large", 12.99);

            //  Convert to JSON
            Gson gson = new Gson();
            String message = gson.toJson(pizza);

            //  Send JSON
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

            System.out.println("Sent JSON: " + message);
        }
    }
}