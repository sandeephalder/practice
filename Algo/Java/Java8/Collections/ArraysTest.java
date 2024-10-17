public class ArraysTest {
    
    interface life{
        default void print(){System.out.println("I am life ");}
    }
    abstract class carnivorus implements life{
        public void print(){System.out.println("I am carnivorus ");}
    }
    class Animal extends carnivorus{
        public void print(){System.out.println("I am Animal ");}
    }

    class Dog extends Animal{
        public void print(){System.out.println("I am Animal ");}
    } 
    
    public static void main(String[] args) {
        new ArraysTest();
    }

    ArraysTest(){
        test1();
        test2();
        test3();
        test4();
    }

    void test3(){
        life[] l1 = new carnivorus[10];
        life[] l2 = new Animal[10];
        life[] l3 = new Dog[10];
    }
    void test4(){
        life[] l = new life[4];
        l[0] = new life(){};
        l[1] = new carnivorus(){};
        l[2] = new Animal(){};
        l[3] = new Dog(){};
        for(int i=0;i<4;i++) l[i].print();
    }
    void test5(){

    }

    void test2(){
        int intArray[][] = new int[10][];
         
        intArray[0] = new int[2]; 
        intArray[0] = new int[12]; 
    
     }

 void test1(){
    int intArray[][] = {{1,2,3},{4,5}};
         
    int cloneArray[][] = intArray.clone();
     
    // will print false
    System.out.println(intArray == cloneArray);
     
    // will print true as shallow copy is created
    // i.e. sub-arrays are shared
    System.out.println(intArray[0] == cloneArray[0]);
    System.out.println(intArray[1] == cloneArray[1]);
    System.out.println(intArray[1][1] == cloneArray[1][1]);
 }
}
