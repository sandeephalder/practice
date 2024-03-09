import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrowIsland {
    /*int[][] grid = {{1,1,0,1,1,0},
                    {1,1,0,1,1,0},
                    {1,1,0,1,1,0},
                    {0,0,1,0,0,0},
                    {0,0,1,1,1,0},
                    {0,0,1,1,1,0}
                    };*/

    int[][] grid = {{1,1,0,1,1,0},
                    {1,1,0,1,1,0},
                    {0,0,0,0,0,0},
                    {1,0,0,0,0,0},
                    {1,1,1,1,1,0},
                    {1,1,1,1,1,0}
                    };          
    int M = grid.length,N=grid[0].length,T=M*N;
    int[] disjointSet = new int[T];
    int[] group = new int[T];
    int d[]= {-1,0,1};

    public static void main(String[] args) {
        new GrowIsland();
    }

    GrowIsland(){
        for(int i=0;i<T;i++){
            disjointSet[i]=i;
            group[i]=1;
        }
        
        System.out.println(largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
       
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==0) continue;

                int src = (i)*N + j;
               
                for(List<Integer> ad:getAdjacent(i, j)){
                    int dest = (ad.get(0)) * N + ad.get(1);
                    
                    if(!isConnected(src, dest)){
                       
                        join(src, dest);
                    }
                }
            } 
        }
        int max=0,total=1;
        for(int i:group) if(max<i) max=i;
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
               
                if(grid[i][j]==0){
                     total=1;
                    for(List<Integer> ad:getAdjacent(i, j)){
                        int dest = (ad.get(0)) * N + ad.get(1);
                            total+=group[dest];
                    }
                if(total>1) total--;
                System.out.println(" Total: "+total);
                if(max<total) max = total;
                }
                
            }
            
        }
        return max;
    }


    private List<List<Integer>> getAdjacent(int x,int y){
        List<List<Integer>> result = new ArrayList<>();
        for(int dx:d){
            int xx= x+dx;
            int yy= y+dx;
            if((xx>=0 && xx<M) && grid[xx][y]==1) {
                if(xx==x) continue; 
                List<Integer> l = new ArrayList<>();
                l.add(xx);
                l.add(y);
                result.add(l);
            }

            if((yy>=0 && yy<N) && grid[x][yy]==1) {
                if(yy==y) continue;
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(yy);
                result.add(l);
            }
        }
        return result;
    }

    private void join(int src,int dest){
        
        int s= disjointSet[src];
        int d= disjointSet[dest];
        int ds=group[s];
        int dd = group[d];
        //System.out.println(" s ==>"+s + " d==> "+d);
        group[src]=ds+dd;
        group[dest]=ds+dd;
        for(int i=0;i<T;i++) 
        if(disjointSet[i]==s) {
            disjointSet[i]=d;
            group[i]=ds+dd;
            //System.out.println("i== "+i+" ds ==>"+ds + " dd==> "+dd +" += "+ Arrays.stream(group).boxed().collect(Collectors.toList()));
        }
    }

    private boolean isConnected(int src,int dest){
        return disjointSet[src]==disjointSet[dest];
    }
}
