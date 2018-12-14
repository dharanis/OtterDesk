package com.example.otterdesk.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Sender extends QueueConfiguration{


    private Logger LOGGER = (Logger) LoggerFactory.getLogger(getClass());
    public Sender(){}
    public Sender(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {

        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}
