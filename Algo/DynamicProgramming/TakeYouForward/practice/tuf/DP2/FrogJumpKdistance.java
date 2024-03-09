package DP2;

import java.util.Arrays;

public class FrogJumpKdistance {

    int k = 2, height[] = {10 ,40 ,30 ,10},n=height.length;
    static int MAX=Integer.MAX_VALUE;

    public static void main(String[] args) {
        new FrogJumpKdistance();
    }

    FrogJumpKdistance(){
          int cache[] = new int[n];
          Arrays.fill(cache,-1);
          System.out.println("Recursive: "+minimizeCostRecursive(1,height,cache));
          System.out.println("Iterative: "+minimizeCostIterative(n-1, height));
          System.out.println("Iterative: "+minimizeCostIterativeEfficient(n-1, height));
          System.out.println();
    }

    
    public int minimizeCostRecursive(int index, int[] height,int cache[]){
        
        if(n>=height.length) return height[height.length-1];
        int result = MAX,l = 0;
        if(cache[index]!=-1) return cache[index];
        for(int i=1;i<=k;i++){
            l=0;
             if(index<i) continue;
            l = minimizeCostRecursive( index+i, height,cache)+
            Math.abs(height[index+i]-height[index]);  
            result = Math.min(l, result);
            // System.out.println(" Index: "+index+" result=> "+result+" l= "+l);
        }
        cache[index]=result;
        return result;
    }

     public int minimizeCostIterative(int n, int[] height){
        int cache[] = new int[n+1];
          Arrays.fill(cache,0);
          
        for(int index=1;index<=n;index++){
            int result = MAX,l = 0;
            for(int i=1;i<=k;i++){
                l=0;
                if(index<i) continue;
            l = cache[index-i]+ Math.abs(height[index-i]-height[index]);  
            result = Math.min(l, result);
             //System.out.println(" Index: "+index+" result=> "+result+" l= "+l);
        }
        cache[index]=result;
        }       
        return cache[n];
    }

    public int minimizeCostIterativeEfficient(int n, int[] height){
        int cache[] = new int[k+1];
          Arrays.fill(cache,0);
          
        for(int index=0;index<=n;index++){
            int result = MAX,ll = 0;
            for(int i=1;i<=k;i++){
                ll=0;
                if(index<i) continue;
            ll = cache[i-1]+ Math.abs(height[index-i]-height[index]);  
            result = Math.min(ll, result);
            // System.out.println(" Index: "+index+" result=> "+result+" l= "+ll);
        for(int l=1;l<=k;l++) cache[l-1]=cache[l];
        cache[k]=result;
        }
       
        }     
        return cache[k];
    }
}
