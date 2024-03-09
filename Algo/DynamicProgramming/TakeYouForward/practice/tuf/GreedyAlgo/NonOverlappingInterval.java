package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingInterval {
    class Task implements  Comparable<Task>{
        int start,end;

        

        public Task(int[] s) {
            this.start = s[0];
            this.end = s[1];
        }

        public int[] getArray(){
            int[] c = new int[2];
            c[0]= this.start;
            c[1]= this.end;
            return c;
        }

        @Override
        public String toString() {
            return "Task [start=" + start + ", end=" + end + "]";
        }



        @Override
        public int compareTo(Task that) {
            return Integer.compare(this.start, that.start);
        }
        
    }

    int[][] intervals ={{1,100},{11,22},{1,11},{2,12}};
    public static void main(String[] args) {
        new NonOverlappingInterval();
    }

    NonOverlappingInterval(){
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        intervals = sort(intervals);
        print(intervals);
        int result =0,start=intervals[0][0],end=intervals[0][1],N=intervals.length;
        for(int i=1;i<N;i++){
            if(intervals[i][0]<end) {
                if(intervals[i][1]<=end){
                    start=intervals[i][0];
                    end=intervals[i][1];
                }
                result++;
            }
            else{
                 start=intervals[i][0];
                end=intervals[i][1];  
            }
        }
        return result;
    }

       private int[][] sort(int[][] s){
        List<Task> res = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            res.add(new Task(s[i]));
        }
        Collections.sort(res);
        int[][] result = new int[res.size()][2];
        for(int i=0;i<s.length;i++) result[i]= res.get(i).getArray();
        return result;
    }

    private void print(int[][] res){
        System.out.println();
        for(int[] i:res) System.out.println(" start= "+i[0]+" end= "+i[1]);
    }
}
