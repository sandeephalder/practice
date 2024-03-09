public class Factorial {
    public static void main(String[] args) {
     new Factorial();    
    }

    Factorial(){
        System.out.println(factorial(10));
    }

    public int factorial(int n){
        if(n==1) return n;

        return n*factorial(n-1);
    }

}
