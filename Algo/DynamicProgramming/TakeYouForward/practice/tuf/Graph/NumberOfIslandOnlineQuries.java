package tuf.Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NumberOfIslandOnlineQuries {

    //int [][] positions = {{0,0},{0,1},{1,2},{2,1}};
    int [][] positions ={{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}};
    int M=4,N=5,T=M*N;
    int[] disjointSet = new int[T];
    int[][] array = new int[M][N];
    boolean[][] visited = new boolean[M][N];
    int d[]= {-1,0,1};
    public static void main(String[] args) {
        new NumberOfIslandOnlineQuries();
    }

    NumberOfIslandOnlineQuries(){
        System.out.println(numIslands2(M, N, positions));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int count=0;
        for(int i=0;i<M;i++){
            Arrays.fill(array[i], 0);
            Arrays.fill(visited[i],false);
        }

        for(int i=0;i<T;i++) disjointSet[i]=i;

        for(int[] i:positions){
            if(!visited[i[0]][i[1]]){
                visited[i[0]][i[1]]=true;
                array[i[0]][i[1]]=1;
                count++;
                for(List<Integer> ad:getAdjacent(i[0], i[1])){
                    int src = (i[0])*N + i[1];
                    int dest = (ad.get(0)) * N + ad.get(1);
                    System.out.println(" ad ==> "+ad+" src = "+src+" dest= "+dest+" adj ==> "+Arrays.stream(disjointSet).boxed().collect(Collectors.toList()));
                    if(!isConnected(src,dest)){
                        count--;
                        join(src,dest);
                    }             
                } 
            }
             result.add(count);
        }
        
        return result;
    }

    private void join(int src,int dest){
        
        int s= disjointSet[src];
        int d= disjointSet[dest];
        for(int i=0;i<T;i++) if(disjointSet[i]==s) disjointSet[i]=d;
    }

    private boolean isConnected(int src,int dest){
        return disjointSet[src]==disjointSet[dest];
    }

    private List<List<Integer>> getAdjacent(int x,int y){
        List<List<Integer>> result = new ArrayList<>();
        for(int dx:d){
            int xx= x+dx;
            int yy= y+dx;
            if((xx>=0 && xx<M) && array[xx][y]==1) {
                if(xx==x) continue; 
                List<Integer> l = new ArrayList<>();
                l.add(xx);
                l.add(y);
                result.add(l);
            }

            if((yy>=0 && yy<N) && array[x][yy]==1) {
                if(yy==y) continue;
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(yy);
                result.add(l);
            }
        }
        return result;
    }
}
