package Graph;

import java.util.List;

public interface Graph {
    public void buildGraph();
    public void buildGraph(int[][] buildGraph);
    public void addEdge(int v,int w);
    public boolean isConnected(int v,int w);
    public Iterable<Integer> adj(int v);
    public int getV();
    public void setV(int v);
    public List[] getGraph();
    public void setGraph(List[] graph);
}
