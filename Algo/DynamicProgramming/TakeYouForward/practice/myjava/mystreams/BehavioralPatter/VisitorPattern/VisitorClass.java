package myjava.mystreams.BehavioralPatter.VisitorPattern;

public class VisitorClass {

    public int calculate(Table table){
        return table.price;
    }
    

    public int calculate(Chair chair){
        return chair.price;
    }
}
