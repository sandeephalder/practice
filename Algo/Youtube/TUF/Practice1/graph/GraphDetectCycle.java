package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphDetectCycle {
    List<List<Integer>> adj;
     int NODES=12;
     boolean visited[];
     int edgeTo[];
     int connect[];

     

     public GraphDetectCycle() {
        buildGraph();
        //System.out.println("Cycle detected: "+isCycle_BFS());
        System.out.println("Cycle detected: "+isCycle_DFS());
    }

    public static void main(String[] args) {
        new GraphDetectCycle();    
       }
   
       private void buildGraph(){
           visited = new boolean[NODES];
           edgeTo = new int[NODES];
           connect = new int[NODES];
           adj = new ArrayList<List<Integer>>();
           for(int i=0;i<NODES;i++){
               adj.add(new ArrayList<Integer>()) ;
               connect[i]=i;
               visited[i]=false;
           }
   
           
           connect(1,2);
           connect(2,4);
           connect(3,5);
           connect(5,6);
           connect(5,10);
           connect(6,7);
           connect(7,8);
           connect(8,11);
           connect(10,9);
           connect(9,8);
   
       }
   
       private void connect(int src,int dest){
        
           adj.get(src).add(dest);
           adj.get(dest).add(src);
          
       }
   
       private List<Integer> adj(int src){
           return adj.get(src);
       }
   
    

       private boolean isCycle_BFS(){
          for(int i=0;i<NODES;i++) {
            if(!visited[i] && isCycle_BFS(i)) return true;
          }

          return false;
       }

       private boolean isCycle_BFS(int src){
           Queue<Tuple> queue = new PriorityQueue<>();
           Tuple t = new Tuple(src, -1);
           queue.offer(t);
           while(!queue.isEmpty()){
                Tuple tuple = queue.poll();
                for(int i: adj(tuple.a)){
                    if(!visited[i]){
                        visited[i]=true;
                        queue.offer(new Tuple(i, tuple.a));
                    }
                    else{
                        if(i!=tuple.b) return true;
                    }
                }
           }
           return false;
       }

       private boolean isCycle_DFS(){
        for(int i=0;i<NODES;i++) {
          if(!visited[i] && isCycle_DFS(i,-1)) return true;
        }

        return false;
     }

     private boolean isCycle_DFS(int src,int parent){
         visited[src]=true;
         for(int i: adj(src)){
            if(!visited[i]){
                visited[i]=true;
                if(isCycle_DFS(i, src)) return true;
            }
            else{
    
                if(i!=parent) return true;
            }
         }
         return false;
     }
}
