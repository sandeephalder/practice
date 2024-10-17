package AccessModifiers.defaultp;

public class DefaultClass {
     int a =10;

     public DefaultClass(){

     }

    int defaultA(){
         System.out.println("Default"+a);
         return a;
     }

    protected int protectedA(){
        System.out.println("Protected"+a);
        return a;
    }

   
     protected void getFinal() throws Exception{
        System.out.println("Final Class");
    }
}


