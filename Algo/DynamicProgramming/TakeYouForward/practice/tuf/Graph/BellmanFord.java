package tuf.Graph;

import java.util.*;

public class BellmanFord {

    class Edge{
        int src,dest,weight;

        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    int[][] edges = new int[4][3];
    Map<Integer,List<Edge>> graph = new HashMap<>();
    int verticies=4;

    public static void main(String[] args) {
        new BellmanFord();
    }

    BellmanFord(){
        edges[0] =new int[]{1,2,4};
        edges[1] =new int[]{1,3,3};
        edges[2] =new int[]{2,4,7};
        edges[3] =new int[]{3,4,-2};
        for(int i=1;i<=verticies;i++)  graph.put(i, new ArrayList<>());
        for(int[] e: edges) 
        graph.get(Integer.valueOf(e[0])).add(new Edge(e[0], e[1], e[2]));
        print(bellmonFord(4,3));
    }

    public int[] bellmonFord(int verticies,int src){
        int e = edges.length; 
        int[] distance = new int[e+1];
        Arrays.fill(distance,Integer.MAX_VALUE/4);
        distance[src]=0;
        for(int i=0;i<e-1;i++)
        for(int[] ed:edges)
         relax(ed, distance);
        return distance;
    }

    public void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }

    public void relax(int s[],int[] distance){
            int src = s[0];
            int dest = s[1];
            int weight = s[2];
            if(distance[dest]== Integer.MAX_VALUE/4|| distance[dest]>distance[src]+weight)
             distance[dest]=distance[src]+weight;
        
    }

    public List<Edge> adj(int src){
        return graph.get(src);
    }


}
