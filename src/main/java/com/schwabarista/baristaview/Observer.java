package com.schwabarista.baristaview;

import com.amazonaws.services.sqs.model.Message;

import java.util.List;

public interface Observer {
    public void update(List<Message> messages);
}
