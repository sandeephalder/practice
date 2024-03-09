package InheretenceCheck;

public class Dog extends Animal {
    
    @Override
    public String getString(){
        System.out.println("Dog name"+this.name);
        return this.name;
    }

    /*public void eat(){
        System.out.println(this.name+" Dog Eat");
    }*/

    public static void eat(int a,int b){
        System.out.println("Dog static eat");
    }

    Dog(){
        this.name="Dog";
    }
}
