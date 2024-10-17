package Generics;

public class ClassB extends ClassA{
    int a=20;

    ClassB(int a){
        super(a);
        this.a=a;
    }

    public void print(){
        System.out.println("Inside Class B");
    }
}
