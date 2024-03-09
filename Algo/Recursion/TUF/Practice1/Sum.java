public class Sum{
    public static void main(String[] args) {
        new Sum();
    }

    Sum(){
            recursiveSum1(10, 0);
            System.out.println(recursiveSum2(10));
    }

    void recursiveSum1(int n,int sum ){
      if(n<=0) {
          System.out.println(sum);
          return;
      }
      
      recursiveSum1(n-1,sum+n); 
      return;
    }

    int recursiveSum2(int n){
        if(n<=0) {
            return n;
        }

        return n+ recursiveSum2(n-1);
    }


}