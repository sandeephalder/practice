package recursion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        new NQueens();
    }

    NQueens(){
        System.out.println(solveNQueens(2));
    }

    public List<List<String>> solveNQueens(int n){
        int N= n;
        List<List<String>> result = new ArrayList<>();
        String[][] strs = new String[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(strs[i], ".");
            Arrays.fill(visited[i], false);
        }
        print(strs);
        putValidQueen(strs, visited, 0, new ArrayList<>(), result);
        System.out.println(isValidPosition(visited, 0, 0));
        return result;
    }

    private boolean putValidQueen(String[][] strs,boolean[][] visited,int index,
    List<String> result,List<List<String>> results){
        int N= strs.length;
        if(index>=N) {
            //results.add(new ArrayList<>(result));
            print(strs);
            return true;
        }
        boolean ret=false;
        for(int i=0;i<N;i++){
            if(visited[index][i]) continue;
            if(isValidPosition(visited, i, index)){
                visited[i][index]=true;
                strs[i][index]="Q";
                for(int j=0;j<N;j++) result.add(strs[j][index]);
                
                ret = putValidQueen(strs, visited, index+1, result, results);
                
                strs[i][index]=".";
                for(int j=0;j<N;j++) result.remove(result.size()-1);
                 visited[i][index]=false;
                 
            }

        }

        return ret;
    }
    private boolean isValidPosition(boolean[][] visited,int x,int y){
        int M=visited.length;
        if(x>M || x<0 || y>M||y<0) return false;
        for(int i=0;i<M;i++){
           if(visited[i][y]) return false;
           if(visited[x][i]) return false;
           if(x+i<M && y+i <M && visited[x+i][y+i]) return false;
           if(x-i >=0 && y+i <M && visited[x-i][y+i]) return false;
            if(x+i<M && y-i >=0 && visited[x+i][y-i]) return false;
           if(x-i >=0 && y-i >=0 && visited[x-i][y-i]) return false;
        }
        return true;
    }
    private void print(String[][] strs){
        System.out.println();
        for(int i=0;i<strs.length;i++){
            System.out.println();
            for(int j=0;j<strs[0].length;j++)
            System.out.print("==>"+strs[i][j]);
        }
    }
}
