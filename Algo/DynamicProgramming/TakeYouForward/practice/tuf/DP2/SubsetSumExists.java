package DP2;

import java.util.Arrays;

public class SubsetSumExists {

    int[] arr ={2,5,1,6,7};
    int TARGET = 22,M= arr.length;
    public static void main(String[] args) {
        new SubsetSumExists();
    }

    SubsetSumExists(){
        int[][] dp = new int[M][TARGET+1];
        for(int i=0;i<M;i++) Arrays.fill(dp[i], -1);
        System.out.println(" recursive: "+subsetSumExistsRecursive(arr, dp, M-1, TARGET));
         //System.out.println(" recursive: "+subsetSumUtil(M-1,TARGET,arr, dp));
        System.out.println(" Iterative: "+subsetSumExistsIterative(arr));
        System.out.println(" Iterative Efficient: "+subsetSumExistsIterativeOptimized(arr));
    }

    private boolean subsetSumExistsRecursive(int ip[],int[][] dp,int index,int sum){
        
        if(sum==0) return true;
        if(index==0) return sum==ip[index];
        
        if(dp[index][sum]!=-1) return dp[index][sum]==1;
        
        
        boolean t=false,n=false;
        if(sum-ip[index]>=0)
        t= subsetSumExistsRecursive(ip, dp, index-1, sum-ip[index]);
        n= subsetSumExistsRecursive(ip, dp, index-1, sum);
        
        dp[index][sum]= (t||n)?1:0;
        return dp[index][sum]==1;
    }

    

    private boolean subsetSumExistsIterative(int ip[]){
        boolean[][] dp = new boolean[M][TARGET+1];      
        for(int i=0;i<M;i++) dp[i][0]=true;  
        if(ip[0]<=TARGET)   
        dp[0][ip[0]] = true;
    
        for(int index=1;index<M;index++){
            for(int sum=1;sum<=TARGET;sum++){
                boolean up=false,prev=false;
                up = dp[index-1][sum];
                if(sum-ip[index]>=0)
                prev = dp[index-1][sum-ip[index]];   
                dp[index][sum]=up || prev; 
            
            }
       
        }
        return dp[M-1][TARGET];
    }

    private boolean subsetSumExistsIterativeOptimized(int ip[]){
        boolean[] prev = new boolean[TARGET+1]; 
        boolean[] current = new boolean[TARGET+1];      
        prev[0]=true;  
        if(ip[0]<=TARGET)   
        prev[ip[0]] = true;
    
        for(int index=1;index<M;index++){
            current = new boolean[TARGET+1]; 
            current[0]=true;  
            for(int sum=1;sum<=TARGET;sum++){
                boolean u=false,p=false;
                u = prev[sum];
                if(sum-ip[index]>=0)
                p = prev[sum-ip[index]];   
               current[sum]=u || p; 
            
            }
        }
        return current[TARGET];
    }
}
