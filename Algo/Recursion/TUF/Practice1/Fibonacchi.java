public class Fibonacchi {
     
    int arr[] = new int[11];
    public static void main(String[] args) {
        new Fibonacchi();    
       }
   
       Fibonacchi(){
           for(int i=0;i<11;i++) arr[i]=-1;
           fibonacchi(10);
       }
   
       public int fibonacchi(int n){
        if(arr[n]!=-1) return arr[n];
           if(n<2) {
            arr[n]=n;
            System.out.println("==>"+n);
            return n;
           }
           
           int fib = fibonacchi(n-1) + fibonacchi(n-2);
           arr[n]=fib;
           System.out.println("==>"+fib);
           return  fib;
       }
   
   }