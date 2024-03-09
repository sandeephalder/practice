package heap2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    int[] arr = {1,2,3,6,2,3,4,7,8};
    int N = arr.length,groupSize=3;

    public boolean isNStraightHand() {
        if(((N) % groupSize)!=0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            int j= arr[i];
            if(map.containsKey(j)) map.put(j, map.get(j));
            else map.put(j,1);

        }
        if(map.size()<groupSize) return false;
        
        return true;
    }
}
