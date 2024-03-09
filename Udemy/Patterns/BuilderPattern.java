public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println(new BuilderPattern.Builder("f","l").addEmail("email").build());
         
    }

       private String fName;
       private String lName;
       private String email;
       private int age;

       

       @Override
    public String toString() {
        return "BuilderPattern [age=" + age + ", email=" + email + ", fName=" + fName + ", lName=" + lName + "]";
    }

    public static class Builder{

        private String fName;
        private String lName;
        private String email;
        private int age=-1;

     
        public Builder(String fName, String lName) {
            this.fName = fName;
            this.lName = lName;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this);
        }

        public Builder addEmail(String email){
            this.email=email;
            return this;
        }

        public Builder addage(int age){
            this.age=age;
            return this;
        }
       
    }

    public BuilderPattern(Builder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.email = builder.email;
        this.age = builder.age;
    }

       
    }



