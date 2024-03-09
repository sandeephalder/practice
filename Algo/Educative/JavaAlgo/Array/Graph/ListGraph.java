package Graph;

import java.util.ArrayList;
import java.util.List;

public class ListGraph implements Graph{
    
    int V;
    List[] graph;
    public static void main(String[] args) {
        ListGraph graph = new ListGraph(13);
        graph.buildGraph();
        System.out.println(" adj "+graph.adj(9));
        System.out.println(" isConnected"+graph.isConnected(6, 0));
        System.out.println(" isConnected"+graph.isConnected(5, 4));
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    

    public List[] getGraph() {
        return graph;
    }

    public void setGraph(List[] graph) {
        this.graph = graph;
    }

    public ListGraph(int V){
        this.V=V;
        graph = new ArrayList[V];
        for(int i=0;i<V;i++) graph[i] = new ArrayList<Integer >();
        buildGraph();
    }

    @Override
    public void buildGraph(){
        int[][] buildGraph = {{0,5},{0,6},{5,3},{5,4},{4,3},{6,1},{6,2},{7,8},{9,10},{9,11},{11,12},{2,7},{8,9}};
        buildGraph(buildGraph);
    }

    @Override
    public void buildGraph(int[][] buildGraph){
        int N= buildGraph.length;
        for(int i=0;i<N;i++) addEdge(buildGraph[i][0], buildGraph[i][1]);
    }

    @Override
    public void addEdge(int v,int w){
        if(!graph[v].contains(w)) graph[v].add(w);
        if(!graph[w].contains(v)) graph[w].add(v);
    }

    @Override
    public boolean isConnected(int v,int w){
        return graph[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v){
       
        return graph[v];
    }
}

