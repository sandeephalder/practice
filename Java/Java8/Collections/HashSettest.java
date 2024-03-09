import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class HashSettest {
  
    public static void main(String[] args) {
        new HashSettest();
    } 
 
    HashSettest(){
        Set<Employee> set =buildEmployee() ;
   
     System.out.println(set);
 
     set.remove(new Employee(1, "Tamal", 74, 567.0d));

     Employee[] emps= set.toArray(new Employee[set.size()]);
 
     System.out.println(set);
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
 
    public Set<Employee> buildEmployee(){
     Set<Employee> set = new HashSet<>();
     Employee e1 = new Employee(1, "Sandeep", 38, 34.0d);
     Employee e2 = new Employee(1, "Kriti", 23, 1.0d);
     Employee e3 = new Employee(1, "Tamal", 74, 567.0d);
     Employee e4 = new Employee(1, "Arpita", 34, 550.0d);
 
     set.add(e1);
     set.add(e2);
     set.add(e3);
     set.add(e4);
     set.add(null);
 
     
     return set;
    }
}