package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        new DFS(new ListGraph(15));
        new DFS(new DiGraph(15));
    }

    DFS(Graph graph){
        System.out.println(" DFS Iterative"+traverseIteretiveDFS(graph));
        
        System.out.println(" DFS Recursive"+traverseRecursiveDFS(graph));
    }

    public List<Integer> traverseIteretiveDFS(Graph graph){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]) traverseIteretiveDFS(graph, i, result, stack, visited, edgeTo);
        }
        System.out.println("traverseIteretiveDFS Edge to ");
        for(int i=0;i<graph.getV();i++){
           System.out.print(" node="+i+"  from="+edgeTo[i]+" <");
        }
        return result ;
    }

    public void traverseIteretiveDFS(Graph graph,int v,List<Integer> result,Stack<Integer> stack,boolean[] visited,int[] edgeTo){
        stack.push(v);
        edgeTo[v]=v;
        while(!stack.isEmpty()){
            int w = stack.pop();
            if(!visited[w])result.add(w);
            visited[w]=true;
            for(int n:graph.adj(w)){
                if(!visited[n]) {
                    edgeTo[n]=w;
                    stack.push(n);
                }
            }
        }
    }

    public List<Integer> traverseRecursiveDFS(Graph graph){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]) traverseRecursiveDFS(graph, i, result, visited, edgeTo);
        }
        System.out.println("traverseRecursiveDFS Edge to ");
        for(int i=0;i<graph.getV();i++){
           System.out.print(" node="+i+"  from="+edgeTo[i]+" <");
        }
        return result;
    }

    public void traverseRecursiveDFS(Graph graph,int v,List<Integer> result,boolean[] visited,int[] edgeTo){
        visited[v] = true;
        result.add(v);
        for(int i:graph.adj(v)){
            if(!visited[i]){
                edgeTo[i]=v;
                traverseRecursiveDFS(graph, i, result, visited, edgeTo);
            }
          
        }
    }
}
