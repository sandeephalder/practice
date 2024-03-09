package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    
    public static void main(String[] args) {
        
        new TopologicalSort(new DiGraph(15));
    }

    TopologicalSort(Graph graph){
        System.out.println(" Topologil Sort:"+topologicalSort(graph));
    }

    public List<Integer> topologicalSort(Graph graph){
        List<Integer> listResult = new ArrayList<>();
        Stack<Integer> result = new Stack<>();
        Stack<Integer> stack= new Stack<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]) topologicalSort(graph, i, result, stack, visited, edgeTo);
        }
        
        while(!result.isEmpty()) listResult.add(result.pop());

        return listResult;
    }

    public void topologicalSort(Graph graph,int v,Stack<Integer> result,Stack<Integer> stack,boolean[] visited,int[] edgeTo){
        stack.push(v);
        edgeTo[v]=v;
        while(!stack.isEmpty()){
            int w = stack.pop();
            if(!visited[w])result.push(w);
            visited[w]=true;
            for(int n:graph.adj(w)){
                if(!visited[n]) {
                    edgeTo[n]=w;
                    stack.push(n);
                }
            }
        }
    }
}