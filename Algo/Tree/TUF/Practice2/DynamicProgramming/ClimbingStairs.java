package DynamicProgramming;

public class ClimbingStairs {

    int N=10;
    ClimbingStairs(){
        int buf [] = new int[N+1];
        for(int i=0;i<=N;i++) buf[i]=-1;
        System.out.println(" countStairs "+countStairs(N,buf));
        for(int i=0;i<=N;i++) buf[i]=-1;
        System.out.println(" countStairsIterative "+countStairsIterative(N,buf));
    }
    public static void main(String[] args) {
        new ClimbingStairs();
    }

    public int countStairs(int n,int buf [] ){
        if(n<2) return n;
        if(buf[n]!=-1) return buf[n];
        buf[n] = countStairs(n-1,buf)+ countStairs(n-2,buf);
        return buf[n];
    }

    public int countStairsIterative(int n,int buf [] ){
        buf[0]=0;
        buf[1]=1;
        for(int i=2;i<=N;i++){
            buf[i] = buf[i-1] + buf[i-2];
        }

        return buf[n];
    }

}
