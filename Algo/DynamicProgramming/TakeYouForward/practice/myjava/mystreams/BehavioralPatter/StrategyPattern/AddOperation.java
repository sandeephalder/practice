package myjava.mystreams.BehavioralPatter.StrategyPattern;

public class AddOperation implements Operation{

    @Override
    public void execute(int a,int b) {
        System.out.println("Adding :"+(a+b));
    }
    
}
