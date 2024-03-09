package Graph.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskersMST {


    List<Edge>[] array;  
    int V;
    public static void main(String[] args) {
        new KruskersMST(8);
    }

    KruskersMST(int V){
        this.V=V;
        array  = new ArrayList[V];
        for(int i=0;i<V;i++) array[i] = new ArrayList<Edge>();
        Queue<Edge> pq = new PriorityQueue<>();
        buildGraph(pq);
    
        System.out.println(" KruskersMST ==> "+kruskersMST(pq));
    }
    public void buildGraph(Queue<Edge> pq){
        int[][] buildGraph = {{0,7,2},{0,4,5},{0,6,13},{0,2,2},{4,5,1},{5,1,89},{7,1,1},{1,2,54},{1,3,23},{3,2,1},{3,6,34},{4,7,100},{4,6,53},{6,2,1},{2,7,34},{5,7,4}};
        buildGraph(buildGraph,pq);
    }

   
    public void buildGraph(int[][] buildGraph,Queue<Edge> pq){
        int N= buildGraph.length;
        for(int i=0;i<N;i++) addEdge(buildGraph[i][0], buildGraph[i][1],buildGraph[i][2],pq);
    }
    public void addEdge(int v,int w,int weight,Queue<Edge> pq){
      Edge edge = new Edge(v, w, weight);
      pq.offer(edge);
      if(!array[v].contains(w)) array[v].add(edge);
      if(!array[w].contains(v)) array[w].add(edge);
    }
    public List<Edge> adj(int v){
        return array[v];
    }
    public List<Edge> kruskersMST(Queue<Edge> pq){
        List<Edge> list = new ArrayList<>();
        UF uf = new UF(V);
        while(!pq.isEmpty()){
            //System.out.print("==>"+pq.poll()+" ");
            Edge edge = pq.poll();
            if(!uf.isConnected(edge.either(), edge.other(edge.either()))) {
                uf.join(edge.either(), edge.other(edge.either()));
                list.add(edge);
            }
        }
        return list;
    }
}
