package myjava.mystreams.BehavioralPatter.ObserverPattern;

public interface Subject {
    
    public void addObserver(Observer observer);   
    public void removeObserver(Observer observer);   
    public void notifyAllObservers(Changed changedParameter);   
}
