package myjava.mystreams.LiscovSubstitution;

public class PetrolCar implements Car{

    @Override
    public void speedUp() {
        System.out.println("Speeding Petrol Car");
    }

    @Override
    public void speedDown() {
        System.out.println("Speeding down Petrol Car");
    }

    @Override
    public void fuel() {
        System.out.println("Fuelling petrol to Petrol Car");
    }
    
}
