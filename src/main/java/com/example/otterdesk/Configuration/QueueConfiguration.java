package com.example.otterdesk.Configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Configuration
public class QueueConfiguration {

    private Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());

    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public QueueConfiguration(){}

    public QueueConfiguration(String endpointName) throws IOException, TimeoutException {
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        //getting a connection
        connection = factory.newConnection();

        //creating a channel
        channel = connection.createChannel();

        //declaring a queue for this channel
        channel.queueDeclare(endpointName, false, false, false, null);


    }
}
