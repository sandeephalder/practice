package tuf.Graph;

import java.util.*;

public class PrimsMST {

    class Edge implements Comparable<Edge>{
        int src,dest,weight;

        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge that){
            return Integer.compare(this.weight, that.weight);
        }

        public int other(int src){
            if(src==this.src) return dest;
            else return src;
        }

        @Override
        public String toString() {
            return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
        }

        
    }

    int[][] edges ={ {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
    //int[][] edges ={ {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
    int V= 5;
    Map<Integer,List<Edge>> graph = new HashMap<>();
    
    public static void main(String[] args) {
        new PrimsMST();
    }

    PrimsMST(){
       
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++) graph.put(i, new ArrayList<>());
        for(int[] edge:edges) 
                    addEdge(edge[0], edge[1], edge[2]);
        Edge start = new Edge(0, 0, 0);
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(start);
        int mst =0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int src = edge.dest;
            int sweight = edge.weight;
            if(visited[src]) continue;
            visited[src]=true;
            mst+=sweight;
            for(Edge d:adj(src)){
                int dest = d.dest;
                
                if(!visited[dest]) pq.offer(d);                
            }
        }

        System.out.println("MST ==> "+mst);
    }

    public void addEdge(int src,int dest,int weight){
        Edge e1 = new Edge(src, dest, weight);
        Edge e2 = new Edge(dest, src, weight);
        graph.get(src).add(e1);
        graph.get(dest).add(e2);
    }

    public List<Edge> adj(int src){
        return graph.get(src);
    }
}
