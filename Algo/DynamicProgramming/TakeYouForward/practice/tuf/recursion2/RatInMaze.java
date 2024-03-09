package recursion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInMaze {

    int maze[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}};

        int[] dx = {-1,0,1};

    public static void main(String[] args) {
        new RatInMaze();
    }

    RatInMaze(){
        System.out.println(findRatMaze(maze));
    }

    public List<String> findRatMaze(int [][]mat) {
        int M= mat.length,N=mat[0].length;
        boolean[][] visited = new boolean[M][N];
        for(int i=0;i<M;i++) Arrays.fill(visited[i], false);
       List<String> result = new ArrayList<>();
       visited[0][0]=true;
       findRatMaze(mat, visited, 0, 0, "", result);
       return result;
    }

    public void findRatMaze(int [][] mat,boolean[][] visited,int x,int y,String level,List<String> result){
        int M= mat.length,N=mat[0].length;
        if(x==M-1 && y == N-1 ) {
            result.add(new String(level));
            return;
        }
        if(x<0 || x>=M || y<0 || y>N) return;

        for(List<Integer> plane: getAllNeighours(mat, x, y)){
            int xx= plane.get(0),yy=plane.get(1),xy=plane.get(2),dx=plane.get(3);
            if(visited[xx][yy]) continue;
            if(xy==1){
                if(dx==-1) level+="L";
                if(dx==1) level+="R";
            }

            if(xy==2){
                if(dx==-1) level+="U";
                if(dx==1) level+="D";
            }
            visited[xx][yy]=true;
            findRatMaze(mat, visited, xx, yy, level, result);
            visited[xx][yy]=false;
            level=level.substring(0, level.length()-1);
        }

    }
    private List<List<Integer>> getAllNeighours(int[][] maze,int x,int y){
        int M=maze.length,N=maze[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i:dx){
            int xx=x+i,yy=y+i;
            if(xx>=0 && xx<M && maze[xx][y]==1) {
                if(xx==x) continue;
                List<Integer> cord = new ArrayList<>();
                cord.add(xx);
                cord.add(y);
                cord.add(2);
                cord.add(i);
               
                result.add(cord);
            }

            if(yy>=0 && yy<N && maze[x][yy]==1) {
                if(yy==y) continue;
                List<Integer> cord = new ArrayList<>();
                cord.add(x);
                cord.add(yy);
                cord.add(1);
                cord.add(i);
                result.add(cord);
            }
        }
        return result;
    }
}
