package tuf.DP;

import java.util.Arrays;

public class FrogKJump {
    int[] jump = {10 ,50,30 ,50};
    int[] dp = new int[jump.length];
    int stairs=2;

    FrogKJump(){
        Arrays.fill(dp, -1);
        System.out.println(findMinKHop(jump, jump.length-1,dp));
        System.out.println(findMinKHopIterative(jump));
    }

    public static void main(String[] args) {
        new FrogKJump();
    }

    private  int findMinKHop(int[] jump,int n,int[] dp){
        if(n<=0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        int number=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
        for(int stair=1;stair<=stairs;stair++){
            number=Integer.MAX_VALUE;
            if(n-stair>=0)
            number = findMinKHop(jump, n-stair,dp) + Math.abs(jump[n]-jump[n-stair]);
            result = Math.min(number,result);
        }
        dp[n]=result;
        return dp[n];
    }

    private  int findMinKHopIterative(int[] jump){
        int n= jump.length;
        Arrays.fill(dp, -1);
        dp[0]=0;
        for(int i=1;i<jump.length;i++){
            int number=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
            for(int stair=1;stair<=stairs;stair++){
                number=Integer.MAX_VALUE;
                if(i-stair>=0)
                number = dp[i-stair] + Math.abs(jump[i]-jump[i-stair]);
                result = Math.min(number,result);
            }
            dp[i]=result;
        }
        return dp[n-1];
    }

    private  int findMinKHopIterativeSpace(int[] jump){
        int n= jump.length;
        
        dp[0]=0;
        for(int i=1;i<n;i++){
            int number=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
            for(int stair=1;stair<=stairs;stair++){
                number=Integer.MAX_VALUE;
                if(i-stair>=0)
                number = dp[i-stair] + Math.abs(jump[i]-jump[i-stair]);
                result = Math.min(number,result);
            }
            dp[i]=result;
        }
        return dp[n-1];
    }
}
