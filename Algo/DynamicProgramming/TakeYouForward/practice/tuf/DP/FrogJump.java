package tuf.DP;

import java.util.Arrays;

public class FrogJump {

    int[] jump = {10 ,50,30 ,10};
    int[] dp = new int[jump.length];

    FrogJump(){
        Arrays.fill(dp, -1);
        System.out.println(findMinHop(jump, jump.length-1,dp));
        System.out.println(findMinHopIterativeSpace(jump));
    }

    public static void main(String[] args) {
        new FrogJump();
    }

    private  int findMinHop(int[] jump,int n,int[] dp){
        if(n<=0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        if(n>=1)
        first = findMinHop(jump, n-1,dp) + Math.abs(jump[n]-jump[n-1]);
        if(n>=2)
        second = findMinHop(jump, n-2,dp) + Math.abs(jump[n]-jump[n-2]);
        dp[n] = Math.min(first,second);
        return dp[n];
    }

    private  int findMinHopIterative(int[] jump){
        int n= jump.length;
        Arrays.fill(dp, -1);
        dp[0]=0;
        for(int i=1;i<jump.length;i++){
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        if(i>=1)
        first = dp[i-1] + Math.abs(jump[i]-jump[i-1]);
        if(i>=2)
        second = dp[i-2] + Math.abs(jump[i]-jump[i-2]);
        dp[i] = Math.min(first,second);
        }
        return dp[n-1];
    }

    private  int findMinHopIterativeSpace(int[] jump){
        int current=0,prev=0,prev2=0;
        for(int i=1;i<jump.length;i++){
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        if(i>=1)
        first = prev + Math.abs(jump[i]-jump[i-1]);
        if(i>=2)
        second = prev2 + Math.abs(jump[i]-jump[i-2]);
        current = Math.min(first,second);
        prev2=prev;
        prev=current;
        }
        return current;
    }
}
