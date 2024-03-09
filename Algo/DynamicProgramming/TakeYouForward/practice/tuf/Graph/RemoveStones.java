package tuf.Graph;

import java.util.*;

public class RemoveStones {

    //int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    int[][] stones =  {{0, 0}, {0, 2},  {1, 3}, {3, 1}, {3, 2}, {4, 3}};
    int M=5,N=5;
    boolean[][] visited = new boolean[M][N];
    int[][] stoneArray = new int[M][N];
    
    public static void main(String[] args) {
        new RemoveStones();
    }

    RemoveStones(){
        int rez =0;
        for(int i=0;i<M;i++){
             Arrays.fill(visited[i],false);
             Arrays.fill(stoneArray[i],-2);
        }
        for(int[] stone:stones) stoneArray[stone[0]][stone[1]]=1;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && stoneArray[i][j]==1)
                {
                   
                     visited[i][j]=true;
                   
                    List<List<Integer>> result = getUnvisitedCordinates(i, j);
                    
                    if(result.size()>0){
                         stoneArray[i][j]=-2;
                         rez++;
                    }
                    
                    System.out.println(" src ==> x= "+i+", y= "+j);
                    System.out.println(" result ==> "+result+" rez== " + rez);
                   
                }
            }
        }
       System.out.println(" Result "+rez);
    }

    private List<List<Integer>> getUnvisitedCordinates(int x,int y){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<M;i++){
            if(!visited[i][y] && stoneArray[i][y]==1) {
                List<Integer> xx = new ArrayList<>();
                xx.add(i);
                xx.add(y);
                result.add(xx);
            }
        }
        for(int i=0;i<N;i++){
            if(!visited[x][i] && stoneArray[x][i]==1) {
                List<Integer> yy = new ArrayList<>();
                yy.add(x);
                yy.add(i);
                result.add(yy);
            }
        }
        return result;
    }
}
