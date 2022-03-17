package com.schwabarista.baristaview;

import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers(List<Message> messages) throws JsonProcessingException;
}
