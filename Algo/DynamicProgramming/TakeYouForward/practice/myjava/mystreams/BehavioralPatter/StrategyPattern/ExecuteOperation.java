package myjava.mystreams.BehavioralPatter.StrategyPattern;

public class ExecuteOperation {
    
    private Operation operation;

    public ExecuteOperation(Operation operation) {
        this.operation = operation;
    }

    public void performOperation(int a,int b){
        operation.execute(a,b);
    }
}
