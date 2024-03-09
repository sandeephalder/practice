package DP2;

import java.util.Arrays;

public class HouseRobberCircular {

    int[] house = {1,2,7,8,10};
    int MIN =-(int)Math.pow(10,5); 

    public static void main(String[] args) {
        new HouseRobberCircular();
    }

    HouseRobberCircular(){
        int N= house.length-1;
        int[] cache1 = new int[N];
        int[] cache2 = new int[N];
        int[] cache3 = new int[N];
        int[] cache4 = new int[N];
        Arrays.fill(cache1,-1);
        Arrays.fill(cache2,-1);
        Arrays.fill(cache3,-1);
        Arrays.fill(cache4,-1);
        int[] house1 = Arrays.copyOfRange(house, 0, house.length-1);
        int[] house2 = Arrays.copyOfRange(house, 1, house.length);
        //System.out.println(findRobberRecursive(house1, cache3, N, N-1));
        System.out.println(" Recursive: "+Math.max(Math.max(findRobberRecursive(house1, cache1, N, N-1),findRobberRecursive(house2, cache2, N, N-1))
         ,Math.max(findRobberRecursive(house1, cache3, N, N-2),findRobberRecursive(house2, cache4, N, N-2))));

         System.out.println(" Iterative: "+Math.max(Math.max(findRobberIterative(house1,0)
         ,findRobberIterative(house2, 0))
         ,Math.max(findRobberIterative(house1, 1),findRobberIterative(house2, 1))));

    }

    public int findRobberRecursive(int[] house,int[] cache,int N,int index){
        if(index<0) return 0;
        if(cache[index]!=-1) return cache[index];
        int res = 0,l = 0;
        for(int i=index-2;i>=0;i--){
            l = findRobberRecursive(house, cache, N, i);
            res = Math.max(l, res);
        }
        cache[index]=res+house[index];
        return cache[index];
    }

    public int findRobberIterative(int[] house,int start){
        int N= house.length-1;
        int current=house[0],prev=0;
       for(int index=1;index<=N;index++){
       int pick=MIN,nonPick=MIN;
       nonPick = current;
       pick=house[index];
       if(index>1)
       pick += prev;
       //System.out.println("index => "+index+"pick => "+pick+"nonPick => "+nonPick);
       prev=current;
       current= Math.max(pick,nonPick);
       }
      
       return current;
    }
    
}
