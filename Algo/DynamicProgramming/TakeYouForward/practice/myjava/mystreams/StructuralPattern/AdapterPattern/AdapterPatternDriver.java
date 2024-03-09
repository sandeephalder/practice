package myjava.mystreams.StructuralPattern.AdapterPattern;

public class AdapterPatternDriver {
    public static void main(String[] args) {
        new AdapterPatternDriver();
    }

    AdapterPatternDriver(){
        Car car = new Car();
        Bus bus = new Bus();
        BiCycle biCycle = new BiCycle();
        BiCycleAdapter biCycleAdapter = new BiCycleAdapter(biCycle);

        car.accelerate();
        bus.accelerate();
        biCycleAdapter.accelerate();
    }
}
