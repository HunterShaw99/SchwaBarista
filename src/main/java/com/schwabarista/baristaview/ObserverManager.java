package com.schwabarista.baristaview;
import com.amazonaws.services.sqs.model.Message;
import com.schwabarista.baristaview.Observer;
import com.schwabarista.baristaview.Subject;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager implements Subject {
    private List<Observer> observers;

    public ObserverManager() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(List<Message> messages) {
        for (Observer observer : observers) {
            observer.update(messages);
        }
    }
}