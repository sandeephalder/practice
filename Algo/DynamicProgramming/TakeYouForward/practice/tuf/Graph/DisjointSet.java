package tuf.Graph;

import java.util.Arrays;

public class DisjointSet {

    int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
    int[] rank = new int[arr.length];
    public static void main(String[] args) {
        new DisjointSet();
    }

    DisjointSet(){
        Arrays.fill(rank,0);
        join(0, 4);
        join(0, 6);
        join(0, 9);
        System.out.println(findParent(9));
        System.out.println(findParent(6));
    }

    public void join(int src,int dest){
        if(rank[src]>rank[dest]){
            arr[findParent(dest)]=findParent(src);
            rank[findParent(dest)] +=rank[findParent(src)];
        }
        else{
            arr[findParent(src)]=findParent(dest);
            rank[findParent(src)] +=rank[findParent(dest)];
        }
    }

    public boolean isConnected(int src,int dest){
        return findParent(src)==findParent(dest);
    }

    public int findParent(int src){
        while(arr[src]!=src) src = arr[src];
        return src;
    }

    public void print(){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
    }
}
