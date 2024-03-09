package recursion2;

import java.util.*;

public class WordSearch {
    
    char[][] board= {{'A','B','C','E'},
                    {'S','F','E','S'},
                    {'A','D','E','E'}};
    int M= board.length,N=board[0].length;
    boolean[][] visited = new boolean[M][N];
    String word = "ABCESEEEFS";
    int[] dx = {-1,0,1};
    public static void main(String[] args) {
        new WordSearch();
    }

    WordSearch(){
         System.out.println(exist(board, word));
        
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==word.charAt(0)) {
                   visited[i][j]=true;
                   if(thereExist(board,visited, word, 1, i, j)) return true;
                   visited[i][j]=false;
                }
            }
        }
        return false;
    }

    public boolean thereExist(char[][] board,boolean[][] visited, String word,int index,int x,int y){
        if(index>=word.length()){
            return true;
        }
        char c = word.charAt(index);
        boolean result=false;
        
        for(List<Integer> cord:getAllNeighours(x, y)){
            int xx=cord.get(0),yy=cord.get(1);
            if(visited[xx][yy]) continue;
            if(board[xx][yy]==c){
                visited[xx][yy]=true;
                result=thereExist(board,visited, word, index+1, xx, yy);
                visited[xx][yy]=false;
                if(result) return result;
            }
        }
        return result;
    }

    private List<List<Integer>> getAllNeighours(int x,int y){
        List<List<Integer>> result = new ArrayList<>();
        for(int i:dx){
            int xx=x+i,yy=y+i;
            if(xx>=0 && xx<M) {
                if(xx==x) continue;
                List<Integer> cord = new ArrayList<>();
                cord.add(xx);
                cord.add(y);
                result.add(cord);
            }

            if(yy>=0 && yy<N) {
                if(yy==y) continue;
                List<Integer> cord = new ArrayList<>();
                cord.add(x);
                cord.add(yy);
                result.add(cord);
            }
        }
        return result;
    }
}
