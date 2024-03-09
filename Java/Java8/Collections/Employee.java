public class Employee  implements Comparable<Employee>{
    
    int id;
    String name;
    int age;
    double salary;


    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
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
        return "Employee [age=" + age + ", id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }


    @Override
    public int compareTo(Employee that){
        if(that ==null) return -1;
        if(this.salary < that.salary) return -1;
        else if(this.salary > that.salary) return 1;
        else return 0;
    }
   
    @Override
    public boolean equals(Object object){
        if(object==null) return false;
        if(object instanceof Employee == false) return false;
        if( this.id != ((Employee)object).id) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return (this.age+this.id+(int)this.salary+this.name.hashCode());
    }
}
