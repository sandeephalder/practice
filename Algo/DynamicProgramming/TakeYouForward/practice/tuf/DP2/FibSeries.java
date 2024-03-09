package DP2;

import java.util.Arrays;

public class FibSeries {
    public static void main(String[] args) {
        new FibSeries();
    }

    FibSeries(){
        int src =1;
        int[] buffer = new int[src+1];
        Arrays.fill(buffer, -1);
        System.out.println(fibSeries(src,buffer));
    }

    private int fibSeries(int src,int buffer[]){
        if(src==0) return 0;
        if(src<2) return 1;
        if(buffer[src]!=-1) return buffer[src];
        buffer[src]=fibSeries(src-1,buffer)+fibSeries(src-2,buffer);
        return buffer[src];
    }
}
