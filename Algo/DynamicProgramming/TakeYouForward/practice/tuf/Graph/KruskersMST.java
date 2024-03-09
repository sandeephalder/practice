package tuf.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KruskersMST {
    class Edge implements Comparable<Edge>{
        int src,dest,weight;

        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge that){
            return Integer.compare(this.weight, that.weight);
        }

        public int other(int src){
            if(src==this.src) return dest;
            else return src;
        }

        @Override
        public String toString() {
            return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
        }    
    }


    int V= 5;
    int[][] edges ={ {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
    //int[][] edges ={ {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
     int[] disjointSet = new int[V];
    
    List<Edge> edgeList = new ArrayList<>();


    public static void main(String[] args) {
        new KruskersMST();
    }

    KruskersMST(){
        List<Edge> mst = new ArrayList<>();
        for(int[] i:edges) edgeList.add(new Edge(i[0], i[1], i[2]));
        Collections.sort(edgeList);
        for(int i=0;i<V;i++) disjointSet[i]=i;
        for(Edge e:edgeList) {
            int src = e.src;
            int dest = e.dest;
            if(!isConnected(src, dest)){
                mst.add(e);
                join(src, dest);
            }
        }

        System.out.println(" KS MST :"+mst);
    }

    private void join(int src,int dest){
        int s = disjointSet[src];
        int t = disjointSet[dest];
        for(int i=0;i<V;i++) if(disjointSet[i]==s) disjointSet[i]=t;
    }

    private boolean isConnected(int src,int dest){
        return disjointSet[src]==disjointSet[dest];
    }
}
