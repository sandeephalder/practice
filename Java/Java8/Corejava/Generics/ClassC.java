package Generics;

public class ClassC extends ClassB{
    int a=30;
    ClassC(int a){
        super(a);
        this.a=a;
    }

    public void print(){
        System.out.println("Inside Class C");
    }
    
}
