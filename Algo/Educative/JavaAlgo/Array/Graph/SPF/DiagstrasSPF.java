package Graph.SPF;
import java.util.ArrayList;
import java.util.List;

import Graph.MST.Edge;
public class DiagstrasSPF {
    List<Edge>[] array;  
    int V;
    int[][] buildGraph = {{0,7,2},{0,4,5},{0,6,13},{0,2,2},{4,5,1},{5,1,89},{7,1,1},{1,2,54},{1,3,23},{3,2,1},{3,6,34},{4,7,100},{4,6,53},{6,2,1},{2,7,34},{5,7,4}};
    public static void main(String[] args) {
        new DiagstrasSPF(10);
    }

    DiagstrasSPF(int V){
        this.V=V;
        array  = new ArrayList[V];
        for(int i=0;i<V;i++) array[i] = new ArrayList<Edge>();
        
        buildGraph();
    
        diagstrasSpf(0);
    }

    public void buildGraph(){
        
        buildGraph(buildGraph);
    }

   
    public void buildGraph(int[][] buildGraph){
        int N= buildGraph.length;
        for(int i=0;i<N;i++) addEdge(buildGraph[i][0], buildGraph[i][1],buildGraph[i][2]);
    }
    public void addEdge(int v,int w,int weight){
      Edge edge = new Edge(v, w, weight);
      
      if(!array[v].contains(w)) array[v].add(edge);
      
    }
    public List<Edge> adj(int v){
        return array[v];
    }

    public List<Edge> diagstrasSpf(int v){
        IndexMinPQ<Integer> pq = new IndexMinPQ<>(buildGraph.length);
        List<Edge> list = new ArrayList<>();
        int distTo[] = new int[V];
        Edge[] edgeTo = new Edge[V];
        for(int i=0;i<V;i++) {
            distTo[i]=99999999;
            edgeTo[i]=null;

        }
        distTo[v]=0;
        pq.insert(v, 0);
        while(!pq.isEmpty()){
            int n = pq.delMin();
            System.out.println(" Node traverse"+n);
            for(Edge edge:adj(n)){
                System.out.println(" Node traverse adjacent nodes"+edge);
                relax(edge,distTo,edgeTo,pq);
            }
        }
        for(int i=0;i<V;i++) System.out.println(" i="+i+" dist="+distTo[i]);
        return list;
    }

    public void relax(Edge e,int[] distTo,Edge[] edgeTo,IndexMinPQ<Integer> pq){
        int v= e.either(), w = e.other(e.either());
        System.out.println(" relax 1 distTo[w] "+distTo[w]+" distTo[v] "+distTo[v]+"  e.getWeight() "+ e.getWeight());
        if(distTo[w] > distTo[v] + e.getWeight()){
            System.out.println(" relax 2 distTo[w] "+distTo[w]+" distTo[v] "+distTo[v]+ e.getWeight());
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w]=e;
            if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
}
