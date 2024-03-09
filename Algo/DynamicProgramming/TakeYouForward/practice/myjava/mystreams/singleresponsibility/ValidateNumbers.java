package myjava.mystreams.singleresponsibility;

public class ValidateNumbers {
    public static IntegerPair validatePair(StringPair stringPair){
        IntegerPair integerPair = new IntegerPair(null, null);

        if (stringPair.getA()==null) {
            throw new RuntimeException("1st Integer is null");
         }
 
         if (stringPair.getB()==null) {
             throw new RuntimeException("2nd Integer is null");
          }
 
         
           try{
             integerPair.setA(Integer.parseInt(stringPair.getA()));   
            }
           catch(java.lang.NumberFormatException  ex){
            integerPair.setA(-1);
             ex.printStackTrace();
           }
 
 
           try{
            integerPair.setB(Integer.parseInt(stringPair.getB()));
           }
           catch(java.lang.NumberFormatException  ex){
             integerPair.setB(-1);
             ex.printStackTrace();
           }
           System.out.println(" Received Integers"+integerPair);
        return integerPair;
    }
}
