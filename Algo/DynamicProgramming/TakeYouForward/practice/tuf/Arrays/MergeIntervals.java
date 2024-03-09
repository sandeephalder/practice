package Arrays;

import java.util.*;

public class MergeIntervals {
    class Tuple implements Comparable<Tuple>{
        int start,end;

        public Tuple(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Tuple other) {
            return Integer.compare(this.start, other.start);
        }
    }

    int[][] interval = {{1,3},{2,6},{8,15},{15,18}};

    public static void main(String[] args) {
        new MergeIntervals();
    }

    MergeIntervals(){
        print(merge(interval));
    }

    public int[][] merge(int[][] interval) {
        List<Tuple> list = sortToTuple(interval);
        int N=interval[0].length,M=interval.length,start=list.get(0).start,end=list.get(0).end;
        List<int[]> result = new ArrayList<>();
        for(int i=1;i<M;i++){
            
            if(end>=list.get(i).start){
                //start = Math.min(start, list.get(i).start);
                end = Math.max(end, list.get(i).end);
            }
            else{
                int[] res = new int[N];
                res[0]=start;
                res[1]=end;
                result.add(res);
                start = list.get(i).start;
                end = list.get(i).end;
            }
            
        }
        int[] res = new int[N];
        res[0]=start;
        res[1]=end;
        result.add(res);
        int[][] r = new  int[result.size()][N];
        for(int i=0;i<result.size();i++) r[i]=result.get(i);
          
        return r;
    }

    private List<Tuple> sortToTuple(int[][] inter) {
        List<Tuple> list = new ArrayList<>();
        for(int[] i:inter) list.add(new Tuple(i[0], i[1]));
        Collections.sort(list);
        return list;
    }

    private void print(int[][] intervals){
            System.out.println();
            for(int[] i:intervals){
                System.out.println(" ["+i[0]+" , "+i[1]+"], ");
                System.out.println();
            }
    }
}
