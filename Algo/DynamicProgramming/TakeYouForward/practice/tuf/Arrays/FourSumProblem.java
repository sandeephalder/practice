package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSumProblem {
     int[] nums = {1,0,-1,0,-2,2};
     int target = 0;

       public static void main(String[] args) {
        new FourSumProblem();
    }

    FourSumProblem(){
       System.out.println("Threesum Solution 1: "+fourSum1(nums));
       System.out.println("Threesum Solution 2: "+fourSum2(nums));
    }

    public List<List<Integer>> fourSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int N=nums.length;
        int sum=0;
        for(int i=0;i<N-1;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<N;j++){
                
                for(int k=j+1;k<N;k++){
                
                sum = target-(nums[i]+nums[j]+nums[k]);
                sum +=  (nums[i]);
                sum +=  (nums[j]);
                sum +=  (nums[k]);
                sum =  target-sum;;
                System.out.println("i== "+i+" j== "+j+" k== "+k+" sum==> "+sum);
                if(map.containsKey(sum)){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[map.get(sum)]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    System.out.println("i== "+i+" j== "+j+" k== "+k);
                    Collections.sort(res);
                    result.add(res);
                }
                map.put(nums[k], k);
                }
                map.put(nums[j], j);
            }
        }
        return result.stream().toList();
    }

    public List<List<Integer>> fourSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int N= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N-1;j++){
                int lo =j+1,hi=N-1;
                long sum=0;
            while(lo<hi){
                sum +=  (nums[i]);
                sum +=  (nums[j]);
                sum +=  (nums[lo]);
                sum +=  (nums[hi]);
                if(sum<target){
                  lo++;
                }
                else if(sum>target){
                      hi--;  
                }

                else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[lo]);
                    res.add(nums[hi]);
                    //System.out.println("i== "+i+" lo== "+lo+" hi== "+hi);
                    Collections.sort(res);
                    result.add(res);
                    lo++;
                    hi--;
                }
            }
            }
          
        }
        return result.stream().toList();
    }
    
}
