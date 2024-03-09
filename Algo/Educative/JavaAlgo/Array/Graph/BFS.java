package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    public static void main(String[] args) {
        new BFS(new ListGraph(15));
        new BFS(new DiGraph(15));
    }

    BFS(Graph graph){
        System.out.println(" BFS Iterative"+traverseIteretiveBFS(graph));
        
        System.out.println(" BFS Recursive"+traverseRecursiveBFS(graph));
    }

    public List<Integer> traverseIteretiveBFS(Graph graph){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue= new LinkedList<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]) traverseIteretiveBFS(graph, i, result, queue, visited, edgeTo);
        }
        System.out.println("traverseIteretiveBFS Edge to ");
        for(int i=0;i<graph.getV();i++){
           System.out.print(" node="+i+"  from="+edgeTo[i]+" <");
        }
        return result ;
    }

    public void traverseIteretiveBFS(Graph graph,int v,List<Integer> result,Queue<Integer> queue,boolean[] visited,int[] edgeTo){
        queue.offer(v);
        edgeTo[v]=v;
        while(!queue.isEmpty()){
            int w = queue.poll();
            if(!visited[w])result.add(w);
            visited[w]=true;
            for(int n:graph.adj(w)){
                if(!visited[n]) {
                    edgeTo[n]=w;
                    queue.offer(n);
                }
            }
        }
    }

    public List<Integer> traverseRecursiveBFS(Graph graph){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) edgeTo[i]=i;
        for(int i=0;i<graph.getV();i++){
            if(!visited[i]){
                result.add(i);
                traverseRecursiveBFS(graph, i, result, visited, edgeTo);
            } 
        }
        System.out.println("traverseRecursiveBFS Edge to ");
        for(int i=0;i<graph.getV();i++){
           System.out.print(" node="+i+"  from="+edgeTo[i]+" <");
        }
        return result;
    }

    public void traverseRecursiveBFS(Graph graph,int v,List<Integer> result,boolean[] visited,int[] edgeTo){
        visited[v] = true;
        
        for(int i:graph.adj(v)){
            if(!visited[i]){
                edgeTo[i]=v;
                result.add(i);
                traverseRecursiveBFS(graph, i, result, visited, edgeTo);
            }
          
        }
    }
}

