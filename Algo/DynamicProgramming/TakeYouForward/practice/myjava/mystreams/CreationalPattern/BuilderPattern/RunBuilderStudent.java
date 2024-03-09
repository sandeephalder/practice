package myjava.mystreams.CreationalPattern.BuilderPattern;

public class RunBuilderStudent {
    public static void main(String[] args) {
        new RunBuilderStudent();
    }

    RunBuilderStudent(){
        Student student = new Student.Builder("sandeep")
        .addLastName("halder")
        .addAddress("Sarjapur")
        .addAge(41)
        .build();
        System.out.println(student);
    }
}
