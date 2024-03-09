package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

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
    
    int[][] intervals = {{1,3},{0,4}};
    public static void main(String[] args) {
        new MergeIntervals();
    }

    MergeIntervals(){
        print(merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        intervals = sort(intervals);
        int n=intervals.length,end=intervals[0][1],start=intervals[0][0];
        List<int[]> result = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(end >= intervals[i][0]){
                end = Math.max(intervals[i][1],end);
            }
            else{
                int[] c = new int[2];
                c[0]=start;
                c[1]=end;
                result.add(c);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        int[] c = new int[2];
        c[0]=start;
        c[1]=end;
        result.add(c);
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++) res[i]=result.get(i); 
        return res;
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
