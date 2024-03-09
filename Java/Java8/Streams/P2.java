import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javafx.print.Collation;

public class P2 {
    public static void main(String[] args) throws IOException {
        new P2();
    }

    P2() throws IOException{
        //map
        Employee[] employeesArray  = buildEmployee().stream().toArray(Employee[]::new);
        Stream.of(employeesArray).forEach(System.out::print);
System.out.println();
        //Flat map

         Arrays.asList(Arrays.asList(1,3,5,7,9),Arrays.asList(2,4,6,8)).stream().forEach(System.out::print);
         System.out.println();
         Arrays.asList(Arrays.asList(1,3,5,7,9),Arrays.asList(2,4,6,8)).stream().flatMap(List::stream).forEach(System.out::print);

        // Peek
        System.out.println("Peek==> "+Arrays.asList(Arrays.asList(1,3,5,7,9),Arrays.asList(2,4,6,8)).stream().flatMap(List::stream).peek(System.out::println).count());

        //skip limit 

        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().skip(3).limit(6).collect(Collectors.toList()));

        //;sored min max

        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().min(Comparator.naturalOrder()));
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().max(Comparator.naturalOrder()));
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //;distinct 

        System.out.println(Arrays.asList(1,4,2,4,1,2,5,4,3,2,1,3).stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        // allMatch NoneMatch anyMatch

        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().allMatch(a-> a%2==1));
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().anyMatch(a-> a%2==1));
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().noneMatch(a-> a%2==1));

        //Int double long stream
        int[] ints = {1,2,3,45,6,9};
        IntStream intStream = Arrays.stream(ints);
        System.out.println(intStream.max());

        long[] longs = {1,2,3,4,5,6,9};
        LongStream longsStream = Arrays.stream(longs);
        System.out.println(longsStream.max());

        double[] doubles = {1.0,2.8,3.32,4.890,5.123,6.654,9.324};
        DoubleStream doublestream = Arrays.stream(doubles);
        System.out.println(doublestream.max());

        
        IntStream intStreamRange = IntStream.range(0, 10);
        System.out.println(intStreamRange.max());

        // reduce

        System.out.println(LongStream.rangeClosed(0, 10).reduce(0, (a,b)-> (a*a+b*b)));

        // Join

        System.out.println(buildEmployee().stream().map(Employee::getName).collect(Collectors.joining(" ,")));

        // toSet toCollection

        System.out.println(buildEmployee().stream().map(Employee::getName).collect(Collectors.toSet()));

        System.out.println(buildEmployee().stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new)));

        // Summarizing double summery Statistics 

        System.out.println(buildEmployee().stream().collect(Collectors.summarizingDouble(Employee::getSalary)));

        System.out.println(buildEmployee().stream().mapToInt(Employee::getAge).summaryStatistics());

        // Partition By 

        Map<Boolean,List<Employee>> partionBy= buildEmployee().stream().collect(Collectors.partitioningBy(a-> a.age%2==1));

        System.out.println(" Partition by age odd: "+partionBy.get(true));
        System.out.println(" Partition by age even: "+partionBy.get(true));

        //Group By 
        Map<String,List<Employee>> groupBy= buildEmployee().stream().collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println(" Group by deperatment: "+groupBy);

        // mapping 

        String mapping= buildEmployee().stream().collect(Collectors.mapping(Employee::getName,Collectors.joining(", ")));

        System.out.println(" Mapping by deperatment: "+mapping);

        // reducing

        Double reducing= buildEmployee().stream().collect(Collectors.reducing(0.0,e -> e.getSalary()*100 ,(a,b) -> a+b));

        System.out.println(" Reducing by salary: "+reducing);

        // Infinite Stream

        System.out.println(Stream.generate(Math::random).limit(6).collect(Collectors.toList())); 

        System.out.println(Stream.iterate(1,i-> i*2).limit(6).collect(Collectors.toList())); 

        // File Write Operation

        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("test.txt")) )){
            buildEmployee().stream().map(Employee::getName).forEach(pw::println);
        }

         // File read Operation

        Files.lines(Paths.get("test.txt")).sorted(Collections.reverseOrder()).forEach(System.out::println);;
        
    }

    public List<Employee> buildEmployee(){
        List<Employee> list = new ArrayList<>();
        Employee e1= new Employee(1,"Sandeep",  "IT",39 ,350000000 ); 
        Employee e2= new Employee(2,"Kriti",  "Medecine",29 ,89564586 ); 
         
        Employee e3= new Employee(3,"Arpita",  "Teaching",35 ,8000 ); 
        Employee e4= new Employee(4,"Tamal",  "Banking",69 ,87956 ); 
        Employee e5= new Employee(5,"Ranadeep",  "IT",39 ,112458 ); 
        Employee e6= new Employee(6,"Poulomi",  "Medecine",28 ,89564586 );
        Employee e7= new Employee(7,"Samrat",  "IT",32 ,390000000 ); 
        Employee e8= new Employee(8,"RajibMam",  "Teaching",45 ,47896 ); 
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


    class Employee{
        int id;
        String name;
        String department;
        int age;
        double salary;
        public Employee(int id, String name, String department, int age, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.age = age;
            this.salary = salary;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
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
        public String toString() {
            return "Employee [age=" + age + ", department=" + department + ", id=" + id + ", name=" + name + ", salary="
                    + salary + "]";
        }
      

   
      
        
        
    }
}
