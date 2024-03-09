import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class CountSubArrayWithSumZero {
    CountSubArrayWithSumZero(){
     int[] arr = {16, 1 ,13 ,-30 ,18 ,-18 ,14 ,11 ,6, 3, -34, 0};
    
     System.out.println(longestSubsetWithZeroSum(arr));
    }
    public static void main(String[] args) {
        new CountSubArrayWithSumZero();
    }

    public int longestSubsetWithZeroSum(int[] arr) {
        int n= arr.length-1;
		return longestSubsetWithZeroSum(arr, n, null);
	}

    public int longestSubsetWithZeroSum(int[] arr,int n,Integer target) {
        List<Integer> list = new ArrayList<>();
        
        for(int i:arr) list.add(i);
        int result=0,sum=0,m=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n;i++) {
            m = list.get(i);
            sum +=m;
            if(sum==0) result=i+1;
            else
            if(map.containsKey(sum)){
                int j= map.get(sum);
                result =Math.max(result,i-j);
            }
            else map.put(sum,i);
        }
        return result;
	}
}
