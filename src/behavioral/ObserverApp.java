package behavioral;

/*
 * The Observer pattern defines a one-to-many dependency between objects, so when one object (the subject) changes state, all its dependent objects (the observers) are notified and updated automatically. This pattern is commonly used in situations where a change in one object requires updating or notifying other related objects.
 *
 * Why use it?
 * - Dynamic subscription
 * - Decoupling subjects from its observer
 * - Real-time event notification
 */

import java.util.ArrayList;
import java.util.List;

//Subscriber is also known as Observer
interface Observer {
    void update(String news);
}

//It also can be called Publisher, Topic or Observable
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String news);
}


class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String news) {
        for (Observer observer: observers) {
            observer.update(news);
        }
    }
}

class Reader implements Observer {
    private final String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.printf("%s received a news update \n", this.name);
        System.out.println(news);
    }
}

public class ObserverApp {
    public static void main(String[] args) {
        Subject newsAgency = new NewsAgency();
        Observer reader1 = new Reader("Eliezer");
        Observer reader2 = new Reader("John");

        newsAgency.addObserver(reader1);
        newsAgency.addObserver(reader2);

        newsAgency.notifyObservers("The good news is that we don't have bad news!");
    }
}
