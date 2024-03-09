package myjava.mystreams.BehavioralPatter.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    int humidity=0,temrature=0,pressure=0;

    List<Observer> observers;

    

    public WeatherStation() {
        this.observers= new ArrayList<>();
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyAllObservers(Changed.HUMIDITY);
    }

    public void setTemrature(int temrature) {
        this.temrature = temrature;
        notifyAllObservers(Changed.TEMP);
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        notifyAllObservers(Changed.PRESSURE);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Changed changedParameter) {
        for(Observer observer:observers){
            switch(changedParameter){
                case TEMP:
                observer.updateTemp(this.temrature);
                break;
                case HUMIDITY:
                observer.updateHumidity(this.humidity);
                break;
                case PRESSURE:
                observer.updatePresure(this.pressure);
                break;
            }
        }
    }

    
}
