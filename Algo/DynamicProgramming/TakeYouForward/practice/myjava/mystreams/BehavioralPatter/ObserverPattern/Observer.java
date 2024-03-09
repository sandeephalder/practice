package myjava.mystreams.BehavioralPatter.ObserverPattern;

public interface Observer {
    public void updateTemp(int temp);
    public void updateHumidity(int hum);
    public void updatePresure(int pressure);
}
