package myjava.mystreams.BehavioralPatter.StrategyPattern;

public class MultiplyOperation implements Operation{

    @Override
    public void execute(int a,int b) {
        System.out.println("Multipling :"+(a*b));
    }
    
}
