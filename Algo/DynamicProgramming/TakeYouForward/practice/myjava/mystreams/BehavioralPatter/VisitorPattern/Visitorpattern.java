package myjava.mystreams.BehavioralPatter.VisitorPattern;

public class Visitorpattern {
    public static void main(String[] args) {
        new Visitorpattern();
    }

    Visitorpattern(){
        int total=0;
        Table table = new Table(12);
        Chair chair = new Chair(23);
        VisitorClass visitorClass = new VisitorClass();
        total +=table.execute(visitorClass);
        total +=chair.execute(visitorClass);
        System.out.println(" Total price"+total);
    }
}
