package myjava.mystreams.BehavioralPatter.VisitorPattern;

public class Table implements Furniture{

    int price;

    

    public Table(int price) {
        this.price = price;
    }



    @Override
    public int execute(VisitorClass visitorClass) {
       return visitorClass.calculate(this);
    }
    
}
