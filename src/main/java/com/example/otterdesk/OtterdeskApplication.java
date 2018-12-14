package com.example.otterdesk;

import com.example.otterdesk.Configuration.Receiver;
import com.example.otterdesk.Configuration.Sender;
import com.example.otterdesk.Entity.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class OtterdeskApplication {

	public static void main(String[] args) throws IOException, TimeoutException {


		Receiver consumer = new Receiver("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Sender producer = new Sender("queue");
		Message message = Message.builder().bluePrintId("5d5f044f-ea3b-4533-9f55-2e1a45b02aab")
				.currentProcessingState("pdf_to_image")
				.fileLocation("https://s3.us-east-2.amazonaws.com/someco.com/uploads/pdfs/74efe087-7949-46db-8a8d-ee06776eb2b0.pdf")
				.createTime(1544404634L)
				.build();
		//Sending message into the queue
		producer.sendMessage(SerializationUtils.serialize(message.toString()));

		SpringApplication.run(OtterdeskApplication.class, args);
	}

}

