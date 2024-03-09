package heap2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray {
    int[][] arr = {{1,4,5},{1,3,4},{2,6}};
    int N= arr.length;
    public static void main(String[] args) {
        new MergeKSortedArray();
    }

    MergeKSortedArray(){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++)
            for(int a:arr[i]) queue.offer(a);
        while(!queue.isEmpty()) result.add(queue.poll());
        System.out.println(result);
    }


}
