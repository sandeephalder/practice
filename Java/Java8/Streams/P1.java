import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.chart.BubbleChart;

class P1{
    public static void main(String[] args) {
       
        new P1();
    }

    P1(){
        Stream<String> stream = Stream.of("a","b","c","d");
        stream.forEachOrdered(System.out::print);
        System.out.println();
        Collection<Integer> collection = Arrays.asList(1,4,3,2,5,6);
        collection.stream().filter(a->a>2).map(a-> a+4).forEach(System.out::print);
        System.out.println();
        List<Integer> list  = Arrays.asList(1,4,3,2,5,6);
        System.out.println();
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee a,Employee b){
                return a.compareTo(b);

            }
        };
        System.out.println(Stream.of("qaaa","abfdf","ac","ad").sorted().collect(Collectors.toList()));
        System.out.println(Stream.of("qaaa","abfdf","ac","ad").sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        System.out.println(Stream.of("qaaa","abfdf","ac","ad").sorted((a,b) -> a.compareTo(b)).collect(Collectors.toList()));
        System.out.println(Stream.of("qaaa","abfdf","ac","ad").sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        System.out.println(buildEmployee().stream().sorted().collect(Collectors.toList()));
        System.out.println(buildEmployee().stream().sorted((a,b) -> (int)(b.salary-a.salary)).collect(Collectors.toList()));
        System.out.println(buildEmployee().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList()));
        System.out.println(buildEmployee().stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()));

        // name to upper case

        System.out.println(Stream.of("a","b","c","d").map(String::toUpperCase).collect(Collectors.toList()));

        // Find first last any 

        System.out.println(Stream.of("a","b","c","d").findFirst());
        System.out.println(Stream.of("a","b","c","d").findAny());

        // Count min max

        System.out.println(Stream.of("a","b","c","d").count());
        System.out.println(Stream.of("a","b","c","d").min((a,b)-> a.compareTo(b)));
        System.out.println(Stream.of("a","b","c","d").max((a,b)-> a.compareTo(b)));
      
        //map sort

        System.out.println(buildEmployee().stream().map(a-> a.name).sorted().collect(Collectors.toList()));
    }


    public List<Employee> buildEmployee(){
        List<Employee> list = new ArrayList<>();
        Employee e1= new Employee("Sandeep",  "IT",39 ,350000000 ); 
        Employee e2= new Employee("Kriti",  "Medecine",29 ,89564586 ); 
         
        Employee e3= new Employee("Arpita",  "Teaching",35 ,8000 ); 
        Employee e4= new Employee("Tamal",  "Banking",69 ,87956 ); 
        Employee e5= new Employee("Ranadeep",  "IT",39 ,112458 ); 
        Employee e6= new Employee("Poulomi",  "Medecine",28 ,89564586 );
        Employee e7= new Employee("Samrat",  "IT",32 ,390000000 ); 
        Employee e8= new Employee("RajibMam",  "Teaching",45 ,47896 ); 
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);

        return list;
    } 


    class Employee implements Comparable<Employee>{
        String name;
        String department;
        int age;
        double salary;

        public Employee(String name, String department, int age, double salary) {
            this.name = name;
            this.department = department;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee other){
            if(this.age < other.age) return -1;
            if(this.age > other.age) return 1;
            return 0;
                
        }

        @Override
        public String toString() {
            return "Employee [age=" + age + ", department=" + department + ", name=" + name + ", salary=" + salary
                    + "]";
        }

        
        
    }
}