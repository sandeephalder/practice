package tuf.recursion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQueenProblem {
    NQueenProblem(){
        int N=4;
        HashMap<Integer,HashMap<Integer,Integer>> board = buildBoard(N);
        //board.get(1).put(1, 1);
        //System.out.println(checkQueenNearBy(board,2 ,3 ));
        nQueenProblem(board,  0);
    }
    public static void main(String[] args) {
        new NQueenProblem();
    }
    private HashMap<Integer,HashMap<Integer,Integer>> buildBoard(int size){
        HashMap<Integer,HashMap<Integer,Integer>> board = new HashMap<>();
        for(int i=0;i<size;i++) {
            HashMap<Integer,Integer> row = new HashMap<>();
            for(int j=0;j<size;j++){
                row.put(j,0);
            }
            board.put(i,row); 
        } 
        return board; 
    }

    private boolean nQueenProblem(HashMap<Integer,HashMap<Integer,Integer>> board,int n){
        int N = board.size();
        boolean isAvailable=false;
        
        if(n>=N) {
            System.out.println(board);
            return true;
        }
        
        for(int i=0;i<N;i++){
                 
            if(checkQueenNearBy(board, i, n)) {
                isAvailable=true;
                board.get(i).put(n, 1);
                nQueenProblem(board, n+1);
                board.get(i).put(n, 0);
            }
        }

        if(!isAvailable) return false;

        return isAvailable;
    }

    private boolean checkQueenNearBy(HashMap<Integer,HashMap<Integer,Integer>> board,int x,int y){
        int N = board.size();
        for(int i=0;i<N;i++){
            
            if((x+i)<N && board.get(x+i).get(y) ==1) return false; 
            if((x-i)>=0 && board.get(x-i).get(y) ==1) return false; 
            if((y+i)<N && board.get(x).get(y+i) ==1) return false; 
            if((y-i)>=0 && board.get(x).get(y-i) ==1) return false; 

            if((x+i)<N && (y+i)<N && board.get(x+i).get(y+i) ==1) return false; 
            if((x-i)>=0 && (y+i)<N && board.get(x-i).get(y+i) ==1) return false; 
            if((x+i)<N && (y-i)>=0 && board.get(x+i).get(y-i) ==1) return false; 
            if((x-i)>=0 && (y-i)>=0 && board.get(x-i).get(y-i) ==1) return false; 
        }
        return true;
    }
}
