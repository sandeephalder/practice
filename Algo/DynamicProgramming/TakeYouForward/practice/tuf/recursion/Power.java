package tuf.recursion;

public class Power {
    public static void main(String[] args) {
        new Power();
    }

    Power(){
        System.out.println(" Power "+(int)pow(2,4));
    }
    
    public double pow(double base,int power){
        double result=1;
        if(power==0) return 1;
        while(power>0){
        if(power%2==1){
            result = result*base;
            power--;
        }
        
        base= base*base;
        power=power/2;
        }
     
        return result;
    }

}
