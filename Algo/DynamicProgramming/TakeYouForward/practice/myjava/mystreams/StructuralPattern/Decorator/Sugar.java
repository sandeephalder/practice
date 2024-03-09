package myjava.mystreams.StructuralPattern.Decorator;

public class Sugar implements Beverage{
    private int price=5;
    private String description="Sugar +";
    private Beverage beverage;

    Sugar(Beverage beverage){
        this.beverage=beverage;
    }

    public int getPrice() {
        return price + beverage.getPrice();
    }

    public String getDescription() {
        return beverage.getDescription()+ description;
    }  

}
