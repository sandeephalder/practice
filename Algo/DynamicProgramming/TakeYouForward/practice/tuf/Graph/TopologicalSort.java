package tuf.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    //int[][] input_edges={{5,4},{0,2},{1,2},{3,1},{0,4}};
    int[][] input_edges={{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}};
    int E=4,V=6;

    public static void main(String[] args) {
        new TopologicalSort();

    }

    TopologicalSort(){
       // System.out.println("Toposort "+topoSort(input_edges, E, V));
       
        for(int[] i:input_edges)
        {
            addEdge(i[0], i[1]);
        }
        System.out.println("Is Cycle : "+hasCycleBFS(input_edges, E, V));
        System.out.println("toposortBFS "+toposortBFSKhans(input_edges,E,V));
    }


     Map<Integer,List<Node>> edges = new HashMap<>();
    class Node{
        int src,dest;
        Node(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
        
        public int other(int s){
            if(s==dest) return src;
            else return dest;
        }
    }

    public boolean hasCycleBFS(int[][] edge, int e, int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        queue.offer(5);
        while(!queue.isEmpty()){
            int n = queue.poll();
            visited[n]=true;
            for(Node node: adj(n)){
                int dest = node.other(n);
                if(visited[dest]) return true;
                if(!visited[dest]){
                    
                    queue.offer(dest);
                } 
            }
        }
        return false;
    }


     public boolean hasCycleDFS(int[][] edge, int e, int v){
        Stack<Integer> queue = new Stack<>();
        Set<Integer> path = new HashSet<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        queue.push(5);
        while(!queue.isEmpty()){
            int n = queue.pop();
            visited[n]=true;
            path.add(n);
            for(Node node: adj(n)){
                int dest = node.other(n);
                if(path.contains(dest)) return true;
                if(!visited[dest]){
                    
                    queue.push(dest);
                } 
            }
        }
        return false;
    }

    public List<Integer> toposortBFSKhans(int[][] edges, int e, int v){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> inDegree = calculateInDegree(edges,v);
        for(int n: inDegree.keySet()) if(inDegree.get(n)==0) queue.offer(n);
        while(!queue.isEmpty()){
            int n = queue.poll();
            result.add(n);
            for(Node node:adj(n)){
                
                inDegree.put(node.dest, inDegree.get(node.dest)-1);
                if(inDegree.get(node.dest)==0) queue.offer(node.dest);
            }
        }
        return result;
    }

    private Map<Integer, Integer> calculateInDegree(int[][] edges, int v) {
        Map<Integer,Integer> indegree = new HashMap<>();
        for(int i=0;i<v;i++) indegree.put(i,0);
        for(int[] a:edges) {
            if(indegree.containsKey(a[1])) indegree.put(a[1],indegree.get(a[1])+1);
        }
        
        return indegree;
    }

    public List<Integer> topoSort(int e, int v){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>(); 
        for(int i=0;i<v;i++) if(!visited[i]) dfs(i, visited, stack);
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    public void dfs(int src,boolean[] visited,Stack<Integer> stack){
        visited[src]=true;
        for(Node n:adj(src)){
            if(!visited[n.other(src)]){
                dfs(n.other(src),visited,stack);
                
            }
        }
        stack.push(src);
    }

    public List<Node> adj(int src){
        if(edges.containsKey(src))
        return edges.get(src);
        else return Collections.EMPTY_LIST;
    }

    public void addEdge(int src,int dest){
        Node n = new Node(src,dest);
        if(!edges.containsKey(src))
            edges.put(src, new ArrayList<Node>());
        edges.get(src).add(n);
    }

}
