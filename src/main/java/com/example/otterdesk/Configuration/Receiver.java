package com.example.otterdesk.Configuration;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Receiver extends QueueConfiguration implements Runnable, Consumer {


    private Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());
    public Receiver(){}
    public Receiver(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConsumeOk(String consumerTag) {
        LOGGER.info("Consumer "+consumerTag +" registered");
    }

    public void handleCancel(String consumerTag) {}
    public void handleCancelOk(String consumerTag) {}
    public void handleRecoverOk(String consumerTag) {}

    //Receive message
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = body.toString();
        LOGGER.info("Message received.");
    }

    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}

}
