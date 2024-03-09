package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BiParteGraph {

    List<List<Integer>> adj;
    int NODES=12;
    boolean visited[];
    int color[];
    
    public static void main(String[] args) {
        new BiParteGraph();
    }

    public BiParteGraph() {
buildGraph();
System.out.println(isBirparte_DFS());
    }



    
       private void buildGraph(){
           visited = new boolean[NODES];
           color = new int[NODES];
           adj = new ArrayList<List<Integer>>();
           for(int i=0;i<NODES;i++){
               adj.add(new ArrayList<Integer>()) ;
               color[i]=-1;
               visited[i]=false;
           }
   
           
           connect(1,2);
           connect(2,3);
           connect(2,9);
           connect(8,5);
           connect(3,4);
           connect(4,5);
           connect(5,6);
           connect(6,7);
          // connect(10,8);
           connect(9,8);
   
       }
   
       private void connect(int src,int dest){
        
           adj.get(src).add(dest);
           adj.get(dest).add(src);
          
       }
   
       private List<Integer> adj(int src){
           return adj.get(src);
       }


       private boolean isBirparte_BFS(){
        return isBirparte_BFS(1);
       }


       private boolean isBirparte_BFS(int src){
         Queue<Integer> queue = new PriorityQueue<>();
         queue.offer(src);
         visited[src] = true;
         color[src]=0;
         System.out.print("==>"+src+"(Color)"+color[src]);
         int c=0;
         while(!queue.isEmpty()){
            int n = queue.poll();
            c = color[n]== 0?1:0;
            for(int i:adj(n)){
               
                if(!visited[i])
                {
                    if(color[i]==-1) color[i]=c;
                    
                    visited[i]=true;
                    queue.offer(i);
                }
                if(color[i]==color[n]) return false;        
            }
         }
        return true;
       }

       private boolean isBirparte_DFS(){
        return isBirparte_DFS(1,0);
       }


       private boolean isBirparte_DFS(int src,int color_code){
         visited[src]= true;
         if(color[src]==-1) color[src]=color_code;
         System.out.print("==>"+src+"(Color)"+color[src]);
          for(int i:adj(src)){
            color_code= color[src]==0?1:0;
            if(color[i] == color[src]) return false;
            if(!visited[i]){
                visited[i] = true;
                if(!isBirparte_DFS(i,color_code)) return false;
            }
          }
        return true;
       }
   
    
}
