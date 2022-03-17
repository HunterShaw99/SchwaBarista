package com.schwabarista.baristaview;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.AmazonSQS;
import java.util.List;

public class ReceiveOrder extends ObserverManager implements Runnable {
    private final String queueURL = "https://sqs.us-east-1.amazonaws.com/261944900994/schwa-coffee.fifo";

    public void run() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();

        while (true) {
            List<Message> messages = sqs.receiveMessage(queueURL).getMessages();

            if (!messages.isEmpty()) {
                notifyObservers(messages);
            }
        }
    }

}
