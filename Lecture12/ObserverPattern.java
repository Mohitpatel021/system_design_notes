package Lecture12;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber{
    void update();
}

interface ISubject{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}
class Subject implements ISubject{
    private String latestVideo;
    private List<ISubscriber> subscribers = new ArrayList<>();
    Subject(String latestVideo){
        this.latestVideo = latestVideo;
    }
    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
    public void uploadVideo(String name){
        this.latestVideo=name;
        notifySubscribers();
        
    }
     public String getVideoData() {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}
class Subscriber implements ISubscriber{
    private String name;
    private Subject subject;
    Subscriber(String name, Subject subject){
        this.name = name;
        this.subject = subject;
    }
    @Override
    public void update() {
        System.out.println("Hey " + name + ", " + subject.getVideoData());
    }
    
}
public class ObserverPattern {
    public static void main(String[] args){
    String latestVideo="System Design";
    Subject subject=new Subject(latestVideo);
    Subscriber subscriber1=new Subscriber("Mohit",subject);
    Subscriber subscriber2=new Subscriber("Ritik",subject);
    subject.subscribe(subscriber1);
    subject.subscribe(subscriber2);
    subject.uploadVideo("Observer Pattern");
    subject.unsubscribe(subscriber2);
    subject.uploadVideo("BNew Video");
    }
}
