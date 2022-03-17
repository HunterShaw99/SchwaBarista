package com.schwabarista.baristaview;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class ReceiveOrder implements Runnable {
    private final String queueURL = "https://sqs.us-east-1.amazonaws.com/261944900994/schwa-coffee.fifo";

    public void run() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();

        while (true) {
            //this list only pulls 1 message?
            List<Message> messages = sqs.receiveMessage(queueURL).getMessages();

            //need to delete to get the next message
            /*for (Message m : messages) {
                sqs.deleteMessage(queueURL, m.getReceiptHandle());
            }*/

            if (!messages.isEmpty()) {
                try {
                    ObserverManager.GetInstance().notifyObservers(messages);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
