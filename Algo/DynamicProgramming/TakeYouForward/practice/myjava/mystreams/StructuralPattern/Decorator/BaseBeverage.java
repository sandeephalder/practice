package myjava.mystreams.StructuralPattern.Decorator;

public class BaseBeverage implements Beverage{
    private int price=5;
    private String description="Base +";

    BaseBeverage(){

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }  

}
