

public class Power {
    double MIN_VALUE= Double.MIN_VALUE;
    Power(){
        System.out.println(myPow(1.84364,-14));
        
    }
    public static void main(String[] args) {
        new Power();
    }

    public double myPow(double x, int n) {
        double result = 1f;
        int pow=Math.abs(n);
        
        while(pow>0){
            if((pow)%2==0){
               
                x=x*x;
                pow=pow/2;
            }
           else {
            result=result*x;
            pow--;
               
            }
        }
        if(n<0) return 1/result;
        return result;
    }
}
