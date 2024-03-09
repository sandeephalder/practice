package myjava.mystreams.LiscovSubstitution;

public class ElectricCar implements Car{

    @Override
    public void speedUp() {
        System.out.println("Speeding Electric Car");
    }

    @Override
    public void speedDown() {
        System.out.println("Speeding down Electric Car");
    }

    @Override
    public void fuel() {
        System.out.println("Fuelling Electric to Electric Car");
    }
    
}
