package InheretenceCheck;

public class Animal {
    String name = "Animal";
    public String getString(){
        System.out.println("Aniomal Name"+name);
        return name;
    }

    public static void eat(int a,int b){
        System.out.println("Animal static eat");
    }
}
