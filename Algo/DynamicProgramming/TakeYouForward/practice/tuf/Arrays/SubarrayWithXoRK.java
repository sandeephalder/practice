package Arrays;

import java.util.*;

public class SubarrayWithXoRK {

    static int[] arr= {1 ,2, 3, 2 };
    static int K= 2;
    public static void main(String[] args) {
        System.out.println(subarraysWithSumK(arr, K));
    }

    public static int subarraysWithSumK(int []a, int b) {
        int count = 0,xor=0,N=a.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<N;i++){
            xor = xor^a[i];
                        
            int remain = xor^b;

            if(map.containsKey(remain))
               count+=map.get(remain);

            if(map.containsKey(xor))
                map.put(xor,map.get(xor)+1);
            else
                map.put(xor, 1);
            
        }
        return count;
    }
}
