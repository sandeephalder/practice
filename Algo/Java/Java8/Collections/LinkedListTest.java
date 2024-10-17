import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    

    public static void main(String[] args) {
        new LinkedListTest();
    } 
 
    LinkedListTest(){
     List<Employee> list =buildEmployee() ;
     Collections.sort(list,createAgeComparatorBuild());
     System.out.println(list);
 
     list.remove(new Employee(1, "Tamal", 74, 567.0d));

     Employee[] emps= list.toArray(new Employee[list.size()]);
 
     System.out.println(list);
    }
    Comparator createAgeComparatorBuild(){
        return new Comparator<Employee>() {
            public int compare(Employee e1,Employee e2){
                 if(e1.age<e2.age) return -1;
                 else if (e1.age>e2.age) return 1;
                 return 0;
            }
        };
    }
 
    Comparator createNameComparatorBuild(){
     return new Comparator<Employee>() {
         public int compare(Employee e1,Employee e2){
             
              return e1.name.compareTo(e2.name);
         }
     };
 }
 
    public List<Employee> buildEmployee(){
     List<Employee> list = new LinkedList<>();
     Employee e1 = new Employee(1, "Sandeep", 38, 34.0d);
     Employee e2 = new Employee(1, "Kriti", 23, 1.0d);
     Employee e3 = new Employee(1, "Tamal", 74, 567.0d);
     Employee e4 = new Employee(1, "Arpita", 34, 550.0d);
 
     list.add(e1);
     list.add(e2);
     list.add(e3);
     list.add(e4);
     list.add(null);
 
     
     return list;
    }
}