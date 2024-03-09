package myjava.mystreams.BehavioralPatter.StrategyPattern;

public class StratagyPattern {
    public static void main(String[] args) {
        new StratagyPattern();
    }

    StratagyPattern(){
        ExecuteOperation executeOperation1 = new ExecuteOperation(new AddOperation());
        executeOperation1.performOperation(23, 34);

        ExecuteOperation executeOperation2 = new ExecuteOperation(new SubstractOperation());
        executeOperation2.performOperation(23, 34);

        ExecuteOperation executeOperation3 = new ExecuteOperation(new MultiplyOperation());
        executeOperation3.performOperation(23, 34);
    }
}
