package myjava.mystreams.singleresponsibility;

import java.util.Scanner;

public class NotRefractored {
    public static void main(String[] args) {
        new NotRefractored();
    }

    NotRefractored (){
        Integer a,b,c;
        System.out.println("Please enter 2 integers");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1st integer");
        String aa= scanner.nextLine();
        System.out.println("Please enter 2nd integer");
        String bb= scanner.nextLine();

        scanner.close();

        if (aa==null) {
           throw new RuntimeException("1st Integer is null");
        }

        if (bb==null) {
            throw new RuntimeException("2nd Integer is null");
         }

        
          try{
            a= Integer.parseInt(aa);
          }
          catch(java.lang.NumberFormatException  ex){
            a=-1;
            ex.printStackTrace();
          }


          try{
            b= Integer.parseInt(bb);
          }
          catch(java.lang.NumberFormatException  ex){
            b=-1;
            ex.printStackTrace();
          }

          c= a+b;

          System.out.println(c);


    }
}
