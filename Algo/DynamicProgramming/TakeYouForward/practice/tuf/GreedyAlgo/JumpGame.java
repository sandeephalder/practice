package GreedyAlgo;

import java.util.Arrays;
import java.util.Stack;

public class JumpGame {
    public static void main(String[] args) {
        int[] jump = {2,3,1,1,4};
        int n= jump.length;
        //System.out.println(jump_search(jump, n));
        System.out.println(" Can Jump: "+canJump(jump));
        System.out.println(" Count min Jump: "+jump(jump));
    }

    public static boolean jump_search(int []jump, int n){
        int step =0,count=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            step = stack.pop();
            count = jump[step];
            for(int j=0;j<count;j++){
                if(step+j+1>=n-1) return true;
                stack.push(step+j+1);
                System.out.println(stack);
            }
        }
        return false;
    }

    public static boolean canJump(int[] jumps) {
        int count=0,n=jumps.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        visited[0]=true;
       for(int i=0;i<n && visited[i] ;i++){
           
           count = jumps[i];
           for(int j=i;j<=count+i;j++){
                visited[j]=true;
               if(j>=n-1) return true;
           }
       }
       return false;
   }
//   {2,3,1,1,4}; 
   public static int jump(int[] nums) {
    int n= nums.length,jump=0;
    int[] visited = new int[n];
    Arrays.fill(visited, Integer.MAX_VALUE);
    visited[0]=0;
    for(int i=0;i<n ;i++){
        jump = nums[i];
        for(int j=i;j<=i+jump;j++){
            if(j>=n) continue;
            visited[j] =  Math.min(visited[j], visited[i]+1);
            
        }
    }
    return visited[n-1];
   }

}
