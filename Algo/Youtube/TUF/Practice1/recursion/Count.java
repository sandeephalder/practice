package recursion;

public class Count {
    public static void main(String[] args) {
        new Count();
    }

    Count(){
        increasingOrder(5);
        System.out.println(increasingOrderSumParameter(5,0));
        System.out.println(increasingOrderSum(5));
        System.out.println("Fib==>"+fib(7));
    }

    public void increasingOrder(int max){
        if(max <0) {
            return ;
        };
        increasingOrder(max-1);
        System.out.println(max);
    }

    public int increasingOrderSumParameter(int max,int sum){
        if(max <0) return sum;
        sum += max;
        return increasingOrderSumParameter(max-1,sum);
    }

    public int increasingOrderSum(int max){
        if(max <0) return 0;
        
        return max+ increasingOrderSum(max-1);
    }

    public int fib(int max){
        if(max <=1) return max;
        
        
        return fib(max-2)+ fib(max-1);
    }
}
