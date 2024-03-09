package tuf.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChepestFlight {

    class Edge implements Comparable<Edge> {
        int x=0;
        int y=0;
        int cost=Integer.MAX_VALUE;
        int hop = 0;
        Edge(int x,int y,int cost,int hop){
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.hop=hop;
        }

        public int other(int s){
            if(s==x) return y;
            return x; 
        }

        

        @Override
        public int compareTo(Edge that){
            return Integer.valueOf(that.hop).compareTo(Integer.valueOf(this.hop));
        }

        @Override
        public String toString(){
            return "{ x= "+this.x+ " , y=" +this.y+" , cost="+this.cost+" ,hop = "+hop+ "}";
        }
    }

       Map<Integer,List<Edge>> graph = new HashMap<>();
       int[][] flights = {{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
       int src=0,  dst=2,  k=4;

    public static void main(String[] args) {
        new ChepestFlight();
    }

    ChepestFlight(){
        System.out.println(findCheapestPrice(11, flights, src, dst, k));
    }
 
     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((graph == null) ? 0 : graph.hashCode());
        result = prime * result + Arrays.deepHashCode(flights);
        result = prime * result + src;
        result = prime * result + dst;
        result = prime * result + k;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChepestFlight other = (ChepestFlight) obj;
        if (graph == null) {
            if (other.graph != null)
                return false;
        } else if (!graph.equals(other.graph))
            return false;
        if (!Arrays.deepEquals(flights, other.flights))
            return false;
        if (src != other.src)
            return false;
        if (dst != other.dst)
            return false;
        if (k != other.k)
            return false;
        return true;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    
        Queue<Edge> pq = new PriorityQueue<>();
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());
        for(int[] i:flights) add(i[0],i[1],i[2]);
        Edge srcnode = new Edge(src,src,0,0);
        pq.offer(srcnode);
        cost[src]=0;
        while(!pq.isEmpty()){
            Edge node = pq.poll();
            
            for(Edge edge:adj(node.y)){
                
                int dest = edge.y;
                int hop = Math.max(node.hop+1,edge.hop);
                if(node.hop>k ) continue;
                edge.hop=Math.max(hop,edge.hop);
                System.out.println("Source ===> src= "+node+" dest= "+edge );
                
               
                if(cost[dest]==Integer.MAX_VALUE){
                    cost[dest]= cost[node.y]+edge.cost;
                    System.out.println("New Node cost[dest] = "+cost[dest] +" node= "+edge);
                    pq.offer(edge);
                }
                else{
                    int tempCost = cost[node.y]+edge.cost;
                    System.out.println("Revisit   path cost[dest] = "+cost[dest] +" tempCost= "+tempCost+" node= "+edge);
                    if(cost[dest] > tempCost) {
                        cost[dest]= tempCost;
                        pq.offer(edge);
                    }
                }
                 //System.out.println(" src= "+node+" dest= "+edge+"  cost= "+cost[dest]+" hop= "+edge.hop);
            }
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }

    private void add(int src,int dest,int cost){
        Edge edge = new Edge(src,dest,cost,0);
        graph.get(src).add(edge);
    }

     private List<Edge> adj(int src){
        return graph.get(src);
    }
}
