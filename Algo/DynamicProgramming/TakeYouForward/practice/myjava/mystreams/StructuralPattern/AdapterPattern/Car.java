package myjava.mystreams.StructuralPattern.AdapterPattern;

public class Car implements Vehicle{

    @Override
    public void accelerate() {
        System.out.println("Running car now");
    }
    
}
