package InheretenceCheck;

import java.io.File;
import java.io.PrintWriter;
import java.util.ConcurrentModificationException;

import javafx.scene.shape.Path;

public class InheretenceCheck {
    public static void main(String[] args) {
        new InheretenceCheck();
    }

    InheretenceCheck(){
        //override upcasting 
        Animal animal = new Dog();
        System.out.println(animal.getString());

        // Downcasting 
        // Dog dog = (Dog)new Animal();
        //dog.eat(); Exception in thread "main" java.lang.ClassCastException: InheretenceCheck.Animal cannot be cast to InheretenceCheck.Dog

        Animal[] animals = {new Dog(),new Animal(),new Dog()};

        for(int i=0;i<animals.length;i++) animals[i].getString();
        //Static Override 
        System.out.println("\n Static override ==> \n");
        for(int i=0;i<animals.length;i++) animals[i].eat(154, 45);


        System.out.println("Interface static method sub check: "+InterfaceCheck.sub(90, 45));

        AbstractCheck abstractCheck = new AbstractCheck() {
            @Override
            public int addAbstract(int a,int b){
                return a+b;
            }
        };

    //Overload check
    short a=1,b=2;
    add(1,2);
    add(1L,2L);
    //add(a,b);

    try{
        throw new ArithmeticException() ;
       // throw new ConcurrentModificationException();
    }
    catch(ArithmeticException | ConcurrentModificationException e){

    }

    

    }

    /*private int add(int a,int b){
        System.out.println("int");
        return a+b;
    }

    private long add(long a,long b){
        System.out.println("long");
        return a+b;
    }

    private short add(short a,short b){
        System.out.println("short");
        return (short)(a+b);
    }

    private Integer add(Integer a,Integer b){
        System.out.println("Integer");
        return a+b;
    }

    private Long add(Long a,Long b){
        System.out.println("Long");
        return a+b;
    }

    private Integer add(Integer... a){
        System.out.println("Integer...");
        return a[0]+a[1];
    }*/

    private Integer add(Object... a){
        System.out.println("Object...");
        return (Integer)a[0]+(Integer)a[1];
    }

}
