package myjava.mystreams.LiscovSubstitution;

public class DiselCar implements Car{

    @Override
    public void speedUp() {
        System.out.println("Speeding Disel Car");
    }

    @Override
    public void speedDown() {
        System.out.println("Speeding down Disel Car");
    }

    @Override
    public void fuel() {
        System.out.println("Fuelling Disel to Disel Car");
    }
    
}
