package AccessModifiers;

import AccessModifiers.defaultp.DefaultClass;

public class Tester extends DefaultClass
{
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.protectedA();
    }
    
    @Override
    protected void getFinal() throws ArithmeticException{
        System.out.println("");
    }
}
