package AccessModifiers.defaultp;

public class Tester extends DefaultClass{
    
    public static void main(String[] args) {
        Tester tester = new Tester();
        System.out.println(tester.defaultA());
        System.out.println(tester.protectedA());
    }
}
