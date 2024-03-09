package Arrays;

import java.util.*;

public class ThreeSum {
    int[] nums = {-2,0,1,1,2};

       public static void main(String[] args) {
        new ThreeSum();
    }

    ThreeSum(){
       // System.out.println("Threesum Solution 1: "+threeSum1(nums));
        System.out.println("Threesum Solution 2: "+threeSum2(nums));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int N=nums.length,sum=0;
        for(int i=0;i<N-1;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<N;j++){
                //System.out.println("i== "+i+" j== "+j);
                sum = 0-(nums[i]+nums[j]);
                if(map.containsKey(sum)){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[map.get(sum)]);
                    res.add(nums[j]);
                    //System.out.println("i== "+i+" j== "+j+" k== "+map.get(sum));
                    Collections.sort(res);
                    result.add(res);
                }
                map.put(nums[j], j);
            }
        }
        return result.stream().toList();
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int N= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<N-1;i++){
            int lo =i+1,hi=N-1,sum=0;
            while(lo<hi){
                sum = nums[i]+nums[lo]+nums[hi];
                if(sum<0){
                  lo++;
                }
                else if(sum>0){
                      hi--;  
                }

                else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
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
        return result.stream().toList();
    }
}
