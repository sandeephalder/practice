package myjava.mystreams.StructuralPattern.Decorator;

public class Cofee implements Beverage{
    private int price=15;
    private String description="Cofee +";
    private Beverage beverage;

    Cofee(Beverage beverage){
        this.beverage=beverage;
    }

    public int getPrice() {
        return price + beverage.getPrice();
    }

    public String getDescription() {
        return beverage.getDescription()+ description;
    }  

}
