package myjava.mystreams.singleresponsibility;

import java.util.Scanner;

public class InputStream {
    
    public static StringPair getInput(){
        StringPair stringPair = new StringPair(null, null);
        System.out.println("Please enter 2 integers");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1st integer");
        stringPair.setA(scanner.nextLine());
        System.out.println("Please enter 2nd integer");
        stringPair.setB(scanner.nextLine());
        scanner.close();
        System.out.println(" Received Strings"+stringPair);
        return stringPair;
    }
}
