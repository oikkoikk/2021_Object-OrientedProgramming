package assignment3;

import java.util.ArrayList;

public abstract class InventoryManager {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    // 입고 알림 신청한 Customer들

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
        //구매대기가 끝난 customer은 삭제!
        observers.removeIf(observer -> ((Customer) observer).getWaitingList().size() == 0);
    }
}
