package tuf.recursion;

public class Fibonacchi {
    Fibonacchi(){
        int N=6;
        
        System.out.println(printFibonacchi(N));
    }

    public static void main(String[] args) {
        new Fibonacchi();
    }

    private int printFibonacchi(int N){
        if(N<=1) return N;

        int result = printFibonacchi(N-1) + printFibonacchi(N-2);
        System.out.println(" result ==>"+result);
        return result;
    }
}
