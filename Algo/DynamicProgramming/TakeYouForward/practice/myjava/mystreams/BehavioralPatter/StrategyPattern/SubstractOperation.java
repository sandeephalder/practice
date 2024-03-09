package myjava.mystreams.BehavioralPatter.StrategyPattern;

public class SubstractOperation implements Operation{

    @Override
    public void execute(int a,int b) {
        System.out.println("Substracting :"+(a-b));
    }
    
}
