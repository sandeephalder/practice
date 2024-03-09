package recursion2;

import java.util.*;

public class MColoringGraph {

    class Edge{
        int src,dest,color;
        Edge(int src,int dest,int color){
            this.src=src;
            this.dest=dest;
            this.color=color;
        }
    }
    int V= 4,E=5,COLOR=4;
    int[][] edges = {{0, 1},
        {1, 2},
        {2, 3},
        {3, 0},
        {0, 2}};

    Map<Integer,List<Edge>> graph = new HashMap<>();
    
    public static void main(String[] args) {
        new MColoringGraph();
    }

    MColoringGraph(){
        System.out.println(findColoring());        
    }

    private String findColoring(){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) graph.put(i, new ArrayList<>());
        Arrays.fill(visited, false);
        for(int[] e:edges){
            Edge ed = new Edge(e[0], e[1], -1);
            graph.get(e[0]).add(ed);
        }
        Queue<Edge> queue = new LinkedList<>();
        Edge start = new Edge(0, 0, 0);
        visited[0]=true;
        queue.offer(start);
        while(!queue.isEmpty()){
            Edge n = queue.poll();
            visited[n.dest]=true;
            int color = n.color;
            for(Edge dest:graph.get(n.dest)){
                if(visited[dest.dest]) continue;
                dest.color=color+1;
                System.out.println(dest.color);
            if(dest.color>=COLOR) return "YES";
                queue.offer(dest);
            }
        }
        return "NO";
    }

}
