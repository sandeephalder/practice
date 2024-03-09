package Graph;

import java.util.ArrayList;
import java.util.List;

public class MatrixGraph {
    int V;
    int[][] graph;
    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(15);
        graph.buildGraph();
        System.out.println(" adj "+graph.adj(9));
        System.out.println(" isConnected"+graph.isConnected(6, 0));
        System.out.println(" isConnected"+graph.isConnected(5, 4));
    }

    public MatrixGraph(int V){
        this.V=V;
        graph = new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                graph[i][j]=0;
                buildGraph();
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    
    public void addEdge(int v,int w){
        graph[v][w] =1;
        graph[w][v] =1;
    }

 
    public boolean isConnected(int v,int w){
        return graph[v][w] ==1;
    }

   
    public Iterable<Integer> adj(int v){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<V;i++) if(graph[v][i]==1)list.add(i);
        return list;
    }


    public void buildGraph(){
        int[][] buildGraph = {{0,5},{0,6},{5,3},{5,4},{4,3},{6,4},{7,8},{9,10},{9,11},{11,12}};
        buildGraph(buildGraph);
    }


    public void buildGraph(int[][] buildGraph){
        int N= buildGraph.length;
        for(int i=0;i<N;i++) addEdge(buildGraph[i][0], buildGraph[i][1]);
    }
}
