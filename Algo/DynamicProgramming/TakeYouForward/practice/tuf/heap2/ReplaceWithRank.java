package heap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReplaceWithRank {
    int[] arr = {1 ,2, 6, 9, 2 };
    public static void main(String[] args) {
        new ReplaceWithRank();
    }

    ReplaceWithRank(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int a: arr)
            queue.offer(a);
        int i=1,prev=-1;
        while(!queue.isEmpty()){
           int a= queue.poll();
           if(prev!=a)
            map.put(a, i++);
            prev = a;
        }
            
        
        for(int a: arr)
          result.add(map.get(a));

        System.out.println(" Replace with Rank: "+result);
    }
}
