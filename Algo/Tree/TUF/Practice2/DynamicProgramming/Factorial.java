package DynamicProgramming;

public class Factorial {
    int N =10;

    public static void main(String[] args) {
        new Factorial();
    }
    Factorial(){
        System.out.println("factorialRecursive ==>"+factorialRecursive(N));
        int fib [] = new int[N+1];
        for(int i=0;i<=N;i++) fib[i]=-1;
        System.out.println("factorialRecursive ==>"+factorialRecursiveDP(N,fib));
        for(int i=0;i<=N;i++) fib[i]=-1;
        System.out.println("factorialIterativeDP ==>"+factorialIterativeDP(fib));
        System.out.println("factorialIterative ==>"+factorialIterative(N));
    }

    private int factorialRecursive(int n)
    {
        if(n<2) return 1;

        return n*factorialRecursive(n-1);
    }

    private int factorialRecursiveDP(int n,int[] buffer)
    {
        if(n<2) return 1;
        if(buffer[n]!=-1) return buffer[n];
        buffer[n] = n*factorialRecursive(n-1);
        return buffer[n];
    }

    private int factorialIterativeDP(int[] buffer)
    {
        buffer[0]=1;
      
        for(int i=1;i<=N;i++){
            buffer[i] = i*buffer[i-1]; 
        }
        return buffer[N];
    }
    private int factorialIterative(int n)
    {
        int current=1,previous=1;
        for(int i=1;i<N;i++){
            current = i*previous;
            previous=current;
        }
        return current;
    }
}
