package myjava.mystreams.BehavioralPatter.ObserverPattern;

public class WeatherClient implements Observer{

    @Override
    public void updateTemp(int temp) {
        System.out.println("temperature changed to: "+temp);
    }

    @Override
    public void updateHumidity(int hum) {
        System.out.println("humidity changed to: "+hum);
    }

    @Override
    public void updatePresure(int pressure) {
        System.out.println("pressure changed to: "+pressure);
    }
    
}
