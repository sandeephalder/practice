package myjava.mystreams.StructuralPattern.Decorator;

public class Runcafe {
    public static void main(String[] args) {
        new Runcafe();
    }

    Runcafe(){
        Beverage myBeverage = new Cofee(new Sugar(new BaseBeverage()))  ;
        System.out.println("Total price : "+myBeverage.getPrice());
        System.out.println("Description : "+myBeverage.getDescription());
    }
}
