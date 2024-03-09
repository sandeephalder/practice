package myjava.mystreams.BehavioralPatter.VisitorPattern;

public class Chair implements Furniture{
    int price;



    public Chair(int price) {
        this.price = price;
    }



    @Override
    public int  execute(VisitorClass visitorClass) {
       return visitorClass.calculate(this);
    }
    
}
