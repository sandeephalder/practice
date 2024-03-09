package tuf.recursion;
import java.util.ArrayList;
import java.util.List;

public class MGraphColor {

    int N=4;
    List<List<Integer>> adj;
    int[] color;
    int colors=0;

    MGraphColor(){
        adj = new ArrayList<>();
        color = new int[N];
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
            color[i]=0;
        }
        buildGraph();
        System.out.println(colorGraph(0));
    }

    private boolean colorGraph(int node){
        boolean result= false;

        if(color[node]!=0) return true;
       
            for(int col=1;col<=colors;col++){
                if(isColor(node, col)){
                    color[node]=col;
                    for(int a:adj(node)) {
                        if(color[a]==0) {
                            if(colorGraph(a)){
                                result= true;
                                return result;
                            }
                            
                          
                        }
                        else return true;
                    }
                   
                }
            }
           
        
         return false;
    }

    private boolean isColor(int node,int col){
        System.out.println(node+" col "+col);
        for(int a:adj(node)){
            System.out.println(node+" node "+a+" col[a] "+color[a]);
            if(color[a]==col) return false;
        }
        
        return true;
    }

    private void add(int x,int y){
        adj.get(x).add(y);
        adj.get(y).add(x);
    }

    private List<Integer> adj(int src){
        return adj.get(src);
    }


    private void buildGraph(){
        add(0,1);
        add(0,2);
        add(0,3);
        add(1,3);
        add(1,2);
    }

    public static void main(String[] args) {
        new MGraphColor();
    }
}
