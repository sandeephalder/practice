public class FibonacchiIterative {
    int FIB=10;
    public static void main(String[] args) {
        new FibonacchiIterative();
    }

    FibonacchiIterative(){
        int prev1=1,prev2=0;
        for(int i=1;i<FIB;i++){
            int fib = prev1+prev2;
            System.out.print(" ==> "+fib);
            prev2=prev1;
            prev1=fib;
        }
        System.out.println(prev1);
    }
}
