import java.util.ArrayList;
import java.util.List;

public class MGraphColoring {

    
    List<Integer>[] graphLists;
    int SIZE=4,m=2;
    int[] color = new int[SIZE];

    MGraphColoring(){
        graphLists = new List[SIZE];
        for(int i=0;i<SIZE;i++) {
            graphLists[i] = new ArrayList<>();
            color[i]=-1;
        }
        buildGraph();
        System.out.println(colorGraph(0, SIZE, m));
    }

    public static void main(String[] args) {
        new MGraphColoring();
    }

    public void buildGraph(){
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(0, 2);
        addEdge(2, 1);
        addEdge(3, 1);

    }

    private boolean colorGraph(int src,int n,int m){
        if(src==n) return true;

        for(int i=0;i<m;i++){
            if(canColor(src, color, i)){
                color[src] = i;
                if(colorGraph(src+1, n, m)) return true;
                color[src]=0;
            }
        }
        return false;
    }

    public boolean canColor(int src,int color[],int col){
        for(int n:adj(src)){
            if(color[n]==col) return false;
        }
        return true;
    }

    public List<Integer> adj(int src){
        return graphLists[src];
    }

    public void addEdge(int src,int dest){
        graphLists[src].add(dest);
        graphLists[dest].add(src);
    }

}
