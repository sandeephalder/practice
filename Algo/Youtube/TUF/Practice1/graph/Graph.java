package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {
     List<List<Integer>> adj;
     int NODES=10;
     boolean visited[];
     int edgeTo[];
     int connect[];
     
    public static void main(String[] args) {
     new Graph();    
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

        adj.get(1).add(2);
        adj.get(2).add(1);
        connect(1,2);

        adj.get(3).add(2);
        adj.get(2).add(3);
        connect(3,2);
        
        adj.get(7).add(2);
        adj.get(2).add(7);
        connect(7,2);

        adj.get(5).add(7);
        adj.get(7).add(5);
        connect(5,7);

        adj.get(3).add(5);
        adj.get(5).add(3);
        connect(3,5);

        adj.get(4).add(6);
        adj.get(6).add(4);
        connect(4,6);

        adj.get(2).add(8);
        adj.get(8).add(2);
        connect(2,8);
    }

    private void connect(int src,int dest){
        int temp = connect[dest];
        for(int i=0;i<NODES;i++) if(connect[i] == temp) connect[i] = connect[src];
    }

    private List<Integer> adj(int src){
        return adj.get(src);
    }

    private boolean isConnected(int src,int dest){
        if( connect[src] == connect[dest]) return true;
        return false;
    }

    private void dfs_R(){
        
        for(int i=0; i< NODES;i++){
            System.out.println("\nDFS Recursive ");
            if(!visited[i]) dfs_R(i);
        }
    }

    private void dfs_R(int src){
        System.out.print(" ==> DFS Recursive node:"+src);
        visited[src] = true;
        for(int i:adj(src)) if(!visited[i]) dfs_R(i);
    }

    private void dfs_Iterative(){
        
        for(int i=0; i< NODES;i++){
            System.out.println("\nDFS Iterative ");
            if(!visited[i]) dfs_Iterative(i);
        }
    }

    private void dfs_Iterative(int src){
                visited[src] = true;
                Stack<Integer> stack = new Stack<>();
                stack.push(src);

                while(!stack.isEmpty()){
                    int n = stack.pop();
                    System.out.println(" ==> DFS Iterative node:"+n);
                    visited[n] = true;
                    for(int i:adj(n))
                    {
                        if(!visited[i]){
                            stack.push(i);
                            
                        } 
                    }
                }

    }

    private void bfs_R(){
        
        for(int i=0; i< NODES;i++){
            System.out.println("\nBFS Recursive ");
            if(!visited[i]) bfs_R(i);
        }
    }

    private void bfs_R(int src){
        System.out.print(" ==> BFS Recursive node:"+src);
        visited[src] = true;
        for(int i:adj(src)) if(!visited[i]) bfs_R(i);
    }

    private void bfs_Iterative(){
        
        for(int i=0; i< NODES;i++){
            System.out.println("\nDFS Iterative ");
            if(!visited[i]) bfs_Iterative(i);
        }
    }

    private void bfs_Iterative(int src){
                visited[src] = true;
                Queue<Integer> queue = new PriorityQueue<>();
                queue.offer(src);
                System.out.println(" ==> BFS Iterative node:"+src);
                while(!queue.isEmpty()){
                    int n = queue.poll();
                   
                    for(int i:adj(n))
                    {
                        if(!visited[i]){
                            visited[i]=true;
                            queue.offer(i);
                            System.out.println(" ==> BFS Iterative node:"+i);
                        } 
                    }
                }

    }

   

  Graph(){
    buildGraph();
    //System.out.println(isConnected(1, 6));
    bfs_Iterative();
  }

}
