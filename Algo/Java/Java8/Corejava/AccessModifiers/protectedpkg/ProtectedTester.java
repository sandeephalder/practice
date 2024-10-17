package AccessModifiers.protectedpkg;

import AccessModifiers.defaultp.DefaultClass;

public class ProtectedTester extends DefaultClass{
    public static void main(String[] args) {
        ProtectedTester protectedTester = new ProtectedTester();
        protectedTester.protectedA();
    }
}
