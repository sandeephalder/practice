package Graph.MST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class PrimsMST {
    
    List<Edge>[] array;  
    int V;
    List<Edge> listOfEdges;
    public static void main(String[] args) {
        new PrimsMST(8);
    }

    PrimsMST(int V){
        this.V=V;
        array  = new ArrayList[V];
        listOfEdges = new ArrayList<>();
        for(int i=0;i<V;i++) array[i] = new ArrayList<Edge>();
        
        buildGraph();
    
        System.out.println(" Prims MST ==> "+primsMST());
    }
    public void buildGraph(){
        int[][] buildGraph = {{0,7,2},{0,4,5},{0,6,13},{0,2,2},{4,5,1},{5,1,89},{7,1,1},{1,2,54},{1,3,23},{3,2,1},{3,6,34},{4,7,100},{4,6,53},{6,2,1},{2,7,34},{5,7,4}};
        buildGraph(buildGraph);
    }

   
    public void buildGraph(int[][] buildGraph){
        int N= buildGraph.length;
        for(int i=0;i<N;i++) addEdge(buildGraph[i][0], buildGraph[i][1],buildGraph[i][2]);
    }
    public void addEdge(int v,int w,int weight){
      Edge edge = new Edge(v, w, weight);
      listOfEdges.add(edge);
      if(!array[v].contains(w)) array[v].add(edge);
      if(!array[w].contains(v)) array[w].add(edge);
    }
    public List<Edge> adj(int v){
        return array[v];
    }
    public List<Edge> primsMST(){
        List<Edge> list = new ArrayList<>();
        Queue<Edge> pq = new PriorityQueue<>();

        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) visited[i]=false;
      
        visit(pq,visited,0);
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int v= e.either() , w=e.other(v);
            if(visited[v] && visited[w]) continue;
            list.add(e);
            if(!visited[v]) visit(pq, visited, v);
            if(!visited[w]) visit(pq, visited, w);
        }
        return list;
    }

    public void visit(Queue<Edge> pq,boolean[] visited,int v){
        visited[v]=true;
        for(Edge e:adj(v)){
            if(!visited[e.other(v)])
               pq.offer(e);
        }
    }
}

