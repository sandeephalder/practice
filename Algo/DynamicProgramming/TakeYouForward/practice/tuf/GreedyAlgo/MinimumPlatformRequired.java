package GreedyAlgo;

import java.util.*;

public class MinimumPlatformRequired {
    static int[] arrival = {41, 1616,297, 2042, 1013 ,987 ,2050 ,525 ,636 ,109};
    static int[] departure = {2275, 2076, 1580 ,2144 ,1231 ,1672, 2137, 1016 ,2234 ,1043 };
    static class Time implements Comparable<Time>{
        int start,end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time that) {
            return Integer.compare(this.start, that.start);
        }

        @Override
        public String toString() {
            return "Time [start=" + start + ", end=" + end + "]";
        }
        
    }
    public static void main(String[] args) {
        System.out.println(calculateMinPatforms(arrival, departure, arrival.length));
    }

    public static int calculateMinPatforms(int at[], int dt[], int n) {
        int end=0,max=Integer.MIN_VALUE;
        Time[]  times= sort(at, dt, n);
        print(times);
        int[] visited = new int[n];
        Arrays.fill(visited,1);
        for(int i=0;i<n;i++) {
            end = times[i].end;
            for(int j=i+1;j<n;j++){
                if(end>=times[j].start){
                   visited[j]++;
                   max= Math.max(visited[j],max);
                }
                else break;
            }
            
        }
        return max;
    }

    public static void print(Time[] arr){
        System.out.println();
        for(Time t:arr) System.out.print(" ==> "+t);
       
    }

    public static Time[] sort(int at[], int dt[], int n){
        Time[] result = new Time[n];
        for(int i=0;i<n;i++) result[i] = new Time(at[i], dt[i]);
        Arrays.sort(result);
        return result;
    }
}
