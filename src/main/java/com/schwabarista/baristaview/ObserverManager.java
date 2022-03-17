package com.schwabarista.baristaview;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.schwabarista.baristaview.Observer;
import com.schwabarista.baristaview.Subject;
import com.schwabarista.baristaview.core.data.OrderManager;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager implements Subject {
    private static ObserverManager instance;
    private List<Observer> observers = new ArrayList<Observer>();

    public static ObserverManager GetInstance() {
        if (instance == null) {
            synchronized (OrderManager.class) {
                if (instance == null) {
                    instance = new ObserverManager();
                }
            }
        }
        return instance;
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(List<Message> messages) throws JsonProcessingException {
        System.out.println("Observers notified.");
        System.out.println(observers);
        for (Observer observer : observers) {
            observer.update(messages);
        }
    }
}