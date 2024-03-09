package heap2;


import java.util.PriorityQueue;

public class KLargestElements {
     int[] arr = {23,345,12,90,432,876,923,438,198,654};
    int k=1;
    public static void main(String[] args) {
        new KLargestElements();
    }

    KLargestElements(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.offer(arr[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        } 
        System.out.println(" Largest Elements: "+minHeap.poll());
    }
}
