package Generics;

import java.util.ArrayList;
import java.util.List;

public class genericsTest {
    public static void main(String[] args) {
        new genericsTest();
    }

    genericsTest(){
        List<? super ClassA> list1 = new ArrayList<ClassA>();
       
        list1.add(new ClassA(10));
        list1.add(new ClassB(20));
        list1.add(new ClassC(30));
        List<? extends ClassA> list2 = new ArrayList<ClassA>();
        
        ClassA classA = new ClassA(10);
        ClassA classB = new ClassB(20);
        test1(new ClassA(10));
        test1(new ClassB(10));
        test1(new ClassC(10));

        //test2(new ClassA(10));
        test2(new ClassB(10));
        test2(new ClassC(10));

        //test3(new ClassA(10));
        //test3(new ClassB(10));
        test3(new ClassC(10));
    }

    public <T extends ClassA>void test1(T c){
        c.print();
    }

    public <T extends ClassB>void test2(T c){
        c.print();
    }

    public <T extends ClassC>void test3(T c){
        c.print();
    }


   
}
