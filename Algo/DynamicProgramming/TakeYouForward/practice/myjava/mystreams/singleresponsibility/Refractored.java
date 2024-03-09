package myjava.mystreams.singleresponsibility;

public class Refractored {
    public static void main(String[] args) {
        new Refractored();
    }

    Refractored(){
        StringPair stringPair = InputStream.getInput();
        IntegerPair integerPair = ValidateNumbers.validatePair(stringPair);
        System.out.println("Answer : "+ProcessPair.processPair(integerPair,(a,b)-> a-b));
    }
}
