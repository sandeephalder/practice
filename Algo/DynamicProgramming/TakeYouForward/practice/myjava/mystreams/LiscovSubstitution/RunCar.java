package myjava.mystreams.LiscovSubstitution;

public class RunCar {
    public static void main(String[] args) {
        new RunCar();
    }
 
    RunCar(){
        Car dCar = new DiselCar();
        Car pCar = new PetrolCar();
        Car eCar = new ElectricCar();

        dCar.speedUp();
        dCar.speedDown();
        dCar.fuel();

        eCar.fuel();

    }
}
