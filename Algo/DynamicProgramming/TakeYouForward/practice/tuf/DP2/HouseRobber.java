package DP2;

import java.util.Arrays;

public class HouseRobber {

    int nums[] = {1,2,2,3},MIN=-(int)Math.pow(10, 4);
    public static void main(String[] args) {
        new HouseRobber();
    }

    HouseRobber(){
        System.out.println("Recursive: "+rob(nums));
        System.out.println("Iterative : "+robHouseIterative(nums,nums.length-1));
        System.out.println("Iterative Effficient: "+robHouseIterativeEfficient(nums,nums.length-1));
    }

    public int rob(int[] nums) {
        int N = nums.length;
        int[] cache = new int[N];
        Arrays.fill(cache,-1);
        return robHouseRecursive(nums, cache, N-1);
    }

    public int robHouseRecursive(int[] nums,int[] cache,int index) {
        if(index<0) return 0;
        if(cache[index]!=-1) return cache[index];
        int pick=nums[index],nonPick=MIN;
        if(index>1)
        pick = robHouseRecursive(nums, cache, index-2);
        nonPick = robHouseRecursive(nums, cache, index-1);
        //System.out.println("index => "+index+"pick => "+pick+"nonPick => "+nonPick);
        cache[index]= Math.max(pick,nonPick);
        return cache[index];
    }


    public int robHouseIterative(int[] nums,int N) {
        int[] cache = new int[N+1];
        Arrays.fill(cache,0);
        cache[0]=nums[0];
        for(int index=1;index<=N;index++){
        int pick=MIN,nonPick=MIN;
        nonPick = cache[index-1];
        pick = nums[index];
        if(index>1)
        pick += cache[index-2];
        System.out.println("index => "+index+"pick => "+pick+"nonPick => "+nonPick);
        cache[index]= Math.max(pick,nonPick);
        }
       
        return cache[cache.length-1];
    }

    public int robHouseIterativeEfficient(int[] nums,int N) {
       // int[] cache = new int[N+1];
       // Arrays.fill(cache,0);
       int current=nums[0],prev=0;
       for(int index=1;index<=N;index++){
       int pick=MIN,nonPick=MIN;
       nonPick = current;
       pick = nums[index];
       if(index>1)
       pick += prev;
       //System.out.println("index => "+index+"pick => "+pick+"nonPick => "+nonPick);
       prev=current;
       current= Math.max(pick,nonPick);
       }
      
       return current;
    }
}
