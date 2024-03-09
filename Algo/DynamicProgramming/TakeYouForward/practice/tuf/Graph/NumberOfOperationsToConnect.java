package tuf.Graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToConnect {

    int[][] edges = {{0,4},{1,6},{2,9},{4,7},{0,6},{6,9},{4,8},{1,4},{4,9},{1,8},{2,8},{3,4},{0,9}};
    int V= 10;
    int[] disjoint = new int[V];
    
    public static void main(String[] args) {
        new NumberOfOperationsToConnect();
    }

    NumberOfOperationsToConnect(){
        System.out.println(makeConnected(V, edges));
    }

    public int makeConnected(int V, int[][] connections) {
        int[] disjoint = new int[V];
        for(int i=0;i<V;i++) disjoint[i]=i;
        int skipList=0,vally=0;
        for(int[] edge:connections) {
            if(isConnected(edge[0], edge[1],disjoint)) skipList++;
            join(edge[0], edge[1],V,disjoint);
        }
        Set<Integer> djset= new HashSet<>();
        for(int i:disjoint) djset.add(i);
        vally=djset.size()-1;
        System.out.println("skipList ==> "+skipList);
        System.out.println("vally ==> "+vally);
        if(skipList>=vally){
            return vally;
        }
        return -1;
    }

    private void join(int src,int dest,int V,int[] disjoint){
        int s= disjoint[src],d= disjoint[dest];
        for(int i=0;i<V;i++) if(disjoint[i]==s) disjoint[i]=d;
    }

    private boolean isConnected(int src,int dest,int[] disjoint){
        return disjoint[src]==disjoint[dest];
    }
}
