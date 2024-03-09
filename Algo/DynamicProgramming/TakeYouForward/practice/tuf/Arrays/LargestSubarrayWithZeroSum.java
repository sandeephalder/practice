package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    static int[] Arr = {1 ,-1, 0 ,0, 2};
    public static void main(String[] args) {
        System.out.println(getLongestZeroSumSubarrayLength(Arr));
    }

    public static int getLongestZeroSumSubarrayLength(int []arr){
        int sum=0,N=arr.length,max=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            sum +=arr[i];
            //System.out.println(" i= "+i+" sum= "+sum+" map= "+map);
            if(sum==0){
                max =i+1;
            }
            else{
                if(map.containsKey(sum)){
                
                    int v = i-map.get(sum);
                    //System.out.println(" i= "+i+" v= "+v);
                    max = Math.max(max,v);
                }
                else
                map.put(sum,i);
            }
        }
        return max;
    }
}
