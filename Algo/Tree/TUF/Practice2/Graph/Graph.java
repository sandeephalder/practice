package Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Graph {

    Map<Integer,Map<Integer,GraphNode>> graph= null; 
    int[][] graphMap = {{1,2,2},{2,4,4},{3,5,5},{5,6,6},{5,10,10},{6,7,7},{7,8,8},{10,9,9},{9,8,8},{8,11,11}};
    int VERTICIES= 12,EDGES=graphMap.length;
    boolean[] visited = new boolean[VERTICIES];
    int[] connected = new int[VERTICIES];
    int[] ncolor = new int[VERTICIES];
    int[] distance = new int[VERTICIES];
    Graph(){
        graph = new HashMap<>();
        for(int i=0;i<VERTICIES;i++) {
            visited[i] = false;
            connected[i]=i;
            ncolor[i]=-1;
            distance[i] = Integer.MAX_VALUE;
        }
        buildGraph();
       // System.out.println(isConnected(3, 11));
       //dfsRecursive(3);
      // dfsIterative(3);
      //bfsIterative(3);
      
      //System.out.println(cycleInGraphDFS(11,11));
      //System.out.println(cycleInGraphBFS(7,0));
      //System.out.println(checkBiparteDFS(11,0));
      //System.out.println(checkBiparteBFS(11));
      //shortestPathBFS(3);
      //System.out.println(" shortestPath "+distance[11]);
      areAnagram("fxkbfdvuj", "gyuevckyh");
    }

    public static boolean areAnagram(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        if(str1.length()==0) return true;
        char[] chars1,chars2;
        chars1 = str1.toCharArray();
        chars2 = str2.toCharArray();

       // Arrays.sort(chars1);
        //Arrays.sort(chars2);
        for(int i=0;i<str1.length() ;i++ ) {
            char c1=chars1[i],c2=chars2[i];
            System.out.println(""+c1+" == " +c2+" "+(c1==c2));
            if(c1!=c2) return false;
        }
        //if(chars1[i]!=chars2[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        new Graph();
    }

    private List<Integer> adj(int src){
        return graph.get(src).entrySet().stream().map( entry -> entry.getKey()).collect(Collectors.toList());
    } 

    private void buildGraph(){
        for(int i=0;i<graphMap.length;i++) addEdge(graphMap[i][0], graphMap[i][1], graphMap[i][2]);
    }

    private void shortestPathBFS(int src){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        distance[src]=0;
        while(!queue.isEmpty()){
            int n= queue.poll();
            visited[n]= true;
            for(int node: adj(n)){
                if(!visited[node]) {
                    distance[node] = 1 + distance[n];
                    queue.offer(node);
                }
            }
            
        }
        
    }

    private boolean cycleInGraphDFS(int src,int parent){
        visited[src] = true;
        boolean result= false;
        for(int n:adj(src)){
            if(n!=parent && visited[n]) return true;
            if(!visited[n]){
                if(cycleInGraphDFS(n,src)) result=true;
            }
        }
        return result;
    }

    private boolean cycleInGraphBFS(int src,int parent){
        boolean result= false;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int n = queue.poll();
            visited[n]=true;
            for(int node: adj(n)){
                if(node!=parent && visited[node]) return true;
                if(!visited[node]) queue.offer(node);
            }
            parent =n;
        }
        return result;
    }

    private boolean checkBiparteDFS(int src,int color){
        visited[src] = true;
        boolean result= true;
        int newColor = color==1?0:1;
        for(int n:adj(src)){
            if(ncolor[n]!=-1 && ncolor[n] == color) return false; 
            if(!visited[n]) {
                ncolor[n]= newColor;
                if(!checkBiparteDFS(n, newColor)) result = false;;
            }
        }
        return result;
    }

    private boolean checkBiparteBFS(int src){
        boolean result= true;
        int newColor = 0;
        ncolor[src]=newColor;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            newColor = newColor==1?0:1;
            int n = queue.poll();
            visited[n]=true;
            for(int node:adj(n)){
                if(ncolor[node]!=-1 && ncolor[node] == ncolor[n]) return false; 
                if(!visited[node]) {
                    ncolor[node]= newColor;
                    queue.offer(node);
                }
            }
        }
        return result;
    }
 
    private void addEdge(int src,int dest,int value){
        GraphNode node = new GraphNode(src, dest, value);
        if(!graph.containsKey(src)) graph.put(src, new HashMap<>());
        if(!graph.containsKey(dest)) graph.put(dest, new HashMap<>());
        graph.get(src).put(dest, node);
        graph.get(dest).put(src, node);
        connect(src, dest);
    }

    private void connect(int src,int dest){
        int temp = connected[src];
        for(int i=0;i< connected.length;i++) if(connected[i]==temp) connected[i] = connected[dest];

    }
    

    private void dfsRecursive(int src){
        visited[src]= true;
        System.out.print("  dfsRecursive ==>"+src);
        for(int n:adj(src)){
            if(!visited[n]) dfsRecursive(n);
        }
    }

    private void dfsIterative(int src){
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            int n = stack.pop();
            if(!visited[n])  System.out.print("  dfsIterative ==>"+n);
            visited[n] = true;
            
            for(int a: adj(n)) if(!visited[a]) {
                stack.push(a);
            }
        }
    }

 

    private void bfsIterative(int src){
        Queue<Integer> stack = new LinkedList();
        stack.offer(src);
        while(!stack.isEmpty()){
            int n = stack.poll();
            if(!visited[n])  System.out.print("  dfsIterative ==>"+n);
            visited[n] = true;
            
            for(int a: adj(n)) if(!visited[a]) {
                stack.offer(a);
            }
        }
    }

}
