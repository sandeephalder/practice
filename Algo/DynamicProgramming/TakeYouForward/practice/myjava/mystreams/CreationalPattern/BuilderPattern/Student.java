package myjava.mystreams.CreationalPattern.BuilderPattern;

public class Student {
    
    private String firstName;
    private String lastName;
    private int age;
    private String address;


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
                + "]";
    }


    private Student(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

   


    public static class Builder{
        private final String firstName;
        private  String lastName="";
        private  int age=0;
        private String address="";

        public Builder(String firstName) {
            this.firstName = firstName;
        
        }

      
        public Student build(){
            
            return new Student(firstName,lastName,age,address);
        }

        public Builder addLastName(String lName){
            this.lastName=lName;
            return this;
        }

        public Builder addAddress(String adress){
            this.address=adress;
            return this;
        }

        public Builder addAge(int a){
            this.age=a;
            return this;
        }


        
    }
    
}
