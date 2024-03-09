package DynamicProgramming;

public class FrogJump {
    FrogJump(){
        int[] energy = {30,10,60,20,30};
        int[] dp = new int[energy.length+1];
        for(int i=0;i<dp.length;i++) dp[i]=-1;
        System.out.println(" Frog Jump recursion: "+frogJumpRecursion(energy.length-1,energy));
        System.out.println(" Frog Jump recursion with DP: "+frogJumpRecursionDP(energy.length-1,energy,dp));

        for(int i=0;i<dp.length;i++) dp[i]=0;

       // System.out.println(" Frog Jump Iteration: "+frogJumpIteration(energy.length-1,energy));
        System.out.println(" Frog Jump Iteration with DP: "+frogJumpIterationDP(energy.length-1,energy,dp));

        System.out.println(" Frog Jump Iteration : "+frogJumpIteration(energy.length-1,energy));


        System.out.println(" Frog K Jump recursion: "+frogKJumpRecursion(energy.length-1,energy,3));

        for(int i=0;i<dp.length;i++) dp[i]=-1;

        System.out.println(" Frog K Jump recursion DP: "+frogKJumpRecursionDP(energy.length-1,energy,2,dp));

        for(int i=0;i<dp.length;i++) dp[i]=0;

        System.out.println(" Frog K Jump Iteration DP: "+frogKJumpIterationDP(energy.length-1,energy,2,dp));

    }

    public static void main(String[] args) {
        new FrogJump();
    }

    private int frogJumpRecursion(int n,int[] energy){
        if(n==0) return 0;
        
        int first = Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        first = frogJumpRecursion(n-1, energy) + Math.abs(energy[n] - energy[n-1]);
        if(n>1)
        second = frogJumpRecursion(n-2, energy)+ Math.abs(energy[n] - energy[n-2]);

        return Math.min(first, second);
    }

    private int frogKJumpRecursion(int n,int[] energy,int k){
        if(n==0) return 0;
        
        int min = Integer.MAX_VALUE,val=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if((n-i)>=0)
            val  = frogKJumpRecursion(n-i, energy,k)+ Math.abs(energy[n] - energy[n-i]);
            min = Math.min(min,val);
        }

        return min;
    }

    private int frogKJumpRecursionDP(int n,int[] energy,int k,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE,val=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if((n-i)>=0)
            val  = frogKJumpRecursionDP(n-i, energy,k,dp)+ Math.abs(energy[n] - energy[n-i]);
            min = Math.min(min,val);
        }
        dp[n]=min;
        return dp[n];
    }

    private int frogKJumpIterationDP(int N,int[] energy,int k,int[] dp){
        
       for(int n=1;n<energy.length;n++){
        int min = Integer.MAX_VALUE,val=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if((n-i)>=0)
            val  = dp[n-i] + Math.abs(energy[n] - energy[n-i]);
            min = Math.min(min,val);
        }
        dp[n]=min;
        }
        
        return dp[energy.length-1];
    }

    private int frogJumpRecursionDP(int n,int[] energy,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int first = Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        first = frogJumpRecursionDP(n-1, energy,dp)  + Math.abs(energy[n] - energy[n-1]);
        if(n>1)
        second = frogJumpRecursionDP(n-2, energy,dp)+ Math.abs(energy[n] - energy[n-2]);
        dp[n] =  Math.min(first, second);
        return dp[n];
    }

    private int frogJumpIterationDP(int n,int[] energy,int[] dp){
        int first = Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        for(int i=1;i<energy.length;i++){
            first = dp[i-1]  + Math.abs(energy[i] - energy[i-1]);
            if(i>1)
            second = dp[i-2] + Math.abs(energy[i] - energy[i-2]);
            dp[i] =  Math.min(first, second);
        }
        return dp[n];
    }

    private int frogJumpIteration(int n,int[] energy){
        
        int first = Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        int prev=energy[1],prevprev=energy[0],current=0;
        for(int i=1;i<energy.length;i++){
            first = prev  + Math.abs(energy[i] - energy[i-1]);
            if(i>1)
            second = prevprev + Math.abs(energy[i] - energy[i-2]);
            current =  Math.min(first, second);
            prevprev=prev;
            prev=current;
        }
        return prevprev;
    }
}
