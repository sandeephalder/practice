package DynamicProgramming;

public class Fibonicci {
    int N=10;
    public static void main(String[] args) {
        new Fibonicci();
    }

    Fibonicci(){
        int fib [] = new int[N+1];
        for(int i=0;i<=N;i++) fib[i]=-1;
       
        System.out.println("fiboRecursion ==> "+fiboRecursion(N,fib));
        for(int i=0;i<=N;i++) fib[i]=-1;
        System.out.println("fiboIterativeDP ==> "+fiboIterativeDP(N,fib));

        System.out.println("fiboIterative ==> "+fiboIterative(N));
    }

    private int  fiboRecursion(int n,int fib[]){
        if(n<2) return n;
        if(fib[n]!=-1) return fib[n];
        fib[n] = fiboRecursion(n-1,fib) + fiboRecursion(n-2,fib);
        return fib[n];
    }

    private int  fiboIterative(int n){
        int current=1,prev=0,fib=0;
        for(int i=2;i<=N;i++){

            fib = current+prev;
            prev = current;
        }
       return fib;
    }


    private int  fiboIterativeDP(int n,int fib[]){
        fib[1]=1;
        fib[0]=0;
        for(int i=2;i<=N;i++){
            fib[n] = fiboRecursion(n-1,fib) + fiboRecursion(n-2,fib);
        }
        return fib[N];
    }
}
