package myjava.mystreams.StructuralPattern.Decorator;

public class Milk implements Beverage{
    private int price=10;
    private String description="Milk +";
    private Beverage beverage;

    Milk(Beverage beverage){
        this.beverage=beverage;
    }

    public int getPrice() {
        return price + beverage.getPrice();
    }

    public String getDescription() {
        return beverage.getDescription()+ description;
    }  

}
