package AccessModifiers.protectedpkg;

public class AnotherProtected extends ProtectedTester{

    int $a = 23;
    int ___b=90;
    int __1_o=9;
    final int a;

public AnotherProtected (){
    a=89;
}
    public static void main(String[] args) {
        AnotherProtected protectedTester = new AnotherProtected();
        protectedTester.protectedA();
    }
}
