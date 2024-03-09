package GreedyAlgo;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    int[][] intervals = {{1,5}};

    int[] newInterval = {2,3};

    public static void main(String[] args) {
        new InsertInterval();
    }

    InsertInterval(){
        print(insert(intervals, newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length,nstart=newInterval[0],nend=newInterval[1],start=0,end=0,mergedstart=nstart,mergedend=nend;
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            start = intervals[i][0];
            end = intervals[i][1];
            if((end<nstart)  ){
                result.add(intervals[i]);
            }
            else if( nstart>=start && nstart <= end){
                System.out.println("start "+start);
                mergedstart=Math.min(mergedstart, start);
            }
            else if( nend>=start && nend <= end){
                System.out.println("end "+end);
                mergedend=Math.max(mergedend, end);
              
            }
            else if(start>nend){

                if(mergedstart !=-1 && mergedend!=-1){
                    int[] newint = new int[2];
                    newint[0]=mergedstart;
                    newint[1]=mergedend;
                    result.add(newint);
                    mergedstart =-1;
                     mergedend=-1;
                }
                result.add(intervals[i]);
               
            }
            
        }

        if(mergedstart !=-1 && mergedend!=-1){
            int[] newint = new int[2];
            newint[0]=mergedstart;
            newint[1]=mergedend;
            result.add(newint);
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++) res[i]=result.get(i); 
        return res;
    }

    private void print(int[][] res){
        System.out.println();
        for(int[] i:res) System.out.println(" start= "+i[0]+" end= "+i[1]);
    }
}
