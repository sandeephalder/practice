package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponent {

    int[] cc;
    public static void main(String[] args) {
        
        new ConnectedComponent(new ListGraph(15));
        new ConnectedComponent(new DiGraph(15));
    }

    ConnectedComponent(Graph graph){
        cc = new int[graph.getV()];
        travrseForConnectedComponent(graph);
        System.out.println(" Is Connected"+isConnected(0,12));
        System.out.println(" Is Connected"+isConnected(0,13));
    }

    public boolean isConnected(int v,int w){
        return cc[v]==cc[w];
    }

    public List<Integer> travrseForConnectedComponent(Graph graph){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        
        int count=0;
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]) travrseForConnectedComponent(graph, i, result, stack, visited, edgeTo,count++);
        }
        
        return result ;
    }

    public void travrseForConnectedComponent(Graph graph,int v,List<Integer> result,Stack<Integer> stack,boolean[] visited,int[] edgeTo,int count){
        stack.push(v);
        edgeTo[v]=v;
        cc[v]=count;
        while(!stack.isEmpty()){
            int w = stack.pop();
            if(!visited[w])result.add(w);
            visited[w]=true;
            for(int n:graph.adj(w)){
                if(!visited[n]) {
                    edgeTo[n]=w;
                    cc[n]=count;
                    stack.push(n);
                }
            }
        }
    }
}
