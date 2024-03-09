package myjava.mystreams.BehavioralPatter.ObserverPattern;

public class ObserverMain {
    public static void main(String[] args) {
        new ObserverMain();
    }

    ObserverMain(){
        WeatherClient client1 = new WeatherClient();
        WeatherClient client2 = new WeatherClient();
        WeatherStation station = new WeatherStation();
        station.addObserver(client1);
        station.setTemrature(23);
        station.addObserver(client2);
        station.setHumidity(13);
       
    }
}
