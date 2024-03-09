package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class DirectedGraph {

    Map<Integer,Map<Integer,GraphNode>> graph= null; 
    int[][] graphMap = {{1,2,2},{2,4,4},{3,5,1},{5,6,2},{10,5,4},{6,7,3},{7,8,2},{9,10,1},{8,9,3},{8,11,4},{5,8,1}};
    Queue<GraphNode> kruskersQueue = new PriorityQueue<>();
    int VERTICIES= 12,EDGES=graphMap.length;
    boolean[] visited = new boolean[VERTICIES];
    int[] connected = new int[VERTICIES];
    int[] ncolor = new int[VERTICIES];
    int[] nweight = new int[VERTICIES];

    DirectedGraph(){
        graph = new HashMap<>();
        for(int i=0;i<VERTICIES;i++) {
            visited[i] = false;
            connected[i]=i;
            ncolor[i]=-1;
            nweight[i]=Integer.MAX_VALUE;
        }
        buildGraph();
        // System.out.println(" isConnected "+isConnected(3, 11));
        //dfsRecursive(3);
      // dfsIterative(3);
      //bfsIterative(3);
      
      //System.out.println(cycleInGraphDFS(3,3));
      //System.out.println(cycleInGraphBFS(1,0));
      //System.out.println(checkBiparteDFS(3,0));
      //System.out.println(checkBiparteBFS(3));
      //System.out.println(" topologicalDFS ");
      //topologicalDFS(1);

      //System.out.println(" topologicalBFS ");
      //topologicalBFS(3);
      //shortestPath(3);
      //System.out.println(" shortestPath "+nweight[10]);
      //primsMST(3);
     // kruskersMST();
     kosurajuSCC(1);
    }

    public static void main(String[] args) {
        new DirectedGraph();
    }

    private void shortestPath(int src){
        Stack<Integer> stack = new Stack<>();
        nweight[src]=0;
        topologicalDFS(src, stack);
        while(!stack.isEmpty()){
            int n = stack.pop();
            relax(n);
        }
    }

    private void primsMST(int src){
        Queue<Integer> queue = new LinkedList<>();
        Queue<GraphNode> primsGraph = new PriorityQueue<>(); 
        queue.offer(src);
        while(!queue.isEmpty()){
            int n = queue.poll();
            visited[n]=true;
            for(GraphNode node:adjNodes(n)){
               if(!visited[node.getDest()]) {
                primsGraph.offer(node);
                queue.offer(node.getDest());
               }
            }
        }
        while(!primsGraph.isEmpty()){
            GraphNode node = primsGraph.poll();
            if(!isConnected(node.getSrc(), node.getDest())){
                System.out.println(" Prims MST ==> "+node);
                connect(node.getSrc(), node.getDest());
            }
        }
        
    }

    private void kruskersMST(){
        int count =0;
        while(!kruskersQueue.isEmpty()){
            GraphNode node = kruskersQueue.poll();
            int source = node.getSrc(),dest = node.getDest(),val = node.getValue();
            if(!isConnected(source, dest)){
                count++;
                connect(source, dest);
                System.out.println("kruskersMST"+ node);
            }
        }
    }

    private void kosurajuSCC(int src){
        Stack<Integer> topologicalQueue = new Stack<>();
        topologicalDFS(src,topologicalQueue);
    for(int i=0;i<VERTICIES;i++) visited[i]=false;
    while(!topologicalQueue.isEmpty())
    {
        int node = topologicalQueue.pop();
        System.out.println(node+"  == "+cycleInGraphBFS(node,node));
        
    }

    }


    private List<Integer> adj(int src){
        return graph.containsKey(src)?graph.get(src).entrySet().stream().map( entry -> entry.getKey()).collect(Collectors.toList()):new ArrayList<>();
    } 

    private void relax(int src){
        int wt = nweight[src];
        for(GraphNode node: adjNodes(src)){
            if(node.getValue() + wt < nweight[node.getDest()] ) nweight[node.getDest()] = node.getValue() + wt;
        }
    }

    private List<GraphNode> adjNodes(int src){
        List<GraphNode> list = new ArrayList<>();
        if(graph.containsKey(src)){
            list = graph.get(src).values().stream().collect(Collectors.toList());
        }
        return list;
    } 

    private void buildGraph(){
        for(int i=0;i<graphMap.length;i++) addEdge(graphMap[i][0], graphMap[i][1], graphMap[i][2]);
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

    private void topologicalDFS(int src){
        visited[src] = true;
        for(int n:adj(src)){
            if(!visited[n]) topologicalDFS(n);
        }
        System.out.print(" topologicalDFS==> "+src);
    }

    private void topologicalDFS(int src,Stack<Integer> stack){
        visited[src] = true;
        stack.push(src);
        for(int n:adj(src)){
            if(!visited[n]) topologicalDFS(n,stack);
        }
        
        
    }


    private void topologicalBFS(int src,Queue<Integer> topologicalQueue){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for(int n:adj(node)){
                if(!visited[n]) queue.offer(n);
            } 
            //System.out.print(" topologicalBFS==> "+node);
            topologicalQueue.offer(node);
        }
    }
 
    private void addEdge(int src,int dest,int value){
        GraphNode node = new GraphNode(src, dest, value);
        if(!graph.containsKey(src)) graph.put(src, new HashMap<>());
        graph.get(src).put(dest, node);
        kruskersQueue.offer(node);
        //connect(src, dest);
    }

    private void connect(int src,int dest){
        int temp = connected[src];
        for(int i=0;i< connected.length;i++) if(connected[i]==temp) connected[i] = connected[dest];

    }

    private boolean isConnected(int src,int dest){
        return connected[src] == connected[dest];
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
