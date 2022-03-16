package com.schwabarista.baristaview;

public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers();
}
