package tuf.recursion;
public class SudukuSolver {
    SudukuSolver(){
        int[][] board= {
            {9, 5, 7, -1, 1, 3, -1, 8, 4},
            {4, 8, 3, -1, 5, 7, 1, -1, 6},
            {-1, 1, 2, -1, 4, 9, 5, 3, 7},
            {1, 7, -1, 3, -1, 4, 9, -1, 2},
            {5, -1, 4, 9, 7, -1, 3, 6, -1},
            {3, -1, 9, 5, -1, 8, 7, -1, 1},
            {8, 4, 5, 7, 9, -1, 6, 1, 3},
            {-1, 9, 1, -1, 3, 6, -1, 7, 5},
            {7, -1, 6, 1, 8, 5, 4, -1, 9}
            };

            
           fillBoard(board);
           printArray(board);
          //  System.out.println(checkIfFits(board, 8, 1, 3));
    }

    public static void main(String[] args) {
        new SudukuSolver();
    }

    private boolean fillBoard(int[][] board){
        int N = board.length;
        System.out.println("Called");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
              if (board[i][j] == -1) {
      
                for (int c = 1; c <= 9; c++) {
                  if (checkIfFits(board, i, j, c)) {
                    board[i][j] = c;
      
                    if (fillBoard(board))
                      return true;
                    else
                      board[i][j] = -1;
                  }
                }
      
                return false;
              }
            }
          }
          return true;

    
    }

    private void printArray(int[][] board){
        int N = board.length;
        System.out.println();
        for(int i=0;i<N ;i++){
            System.out.println();
            for(int j=0;j<N ;j++)
              System.out.print(" "+board[i][j]);
        }
    }

    private boolean checkIfFits(int[][] board,int x,int y,int value){
        int N = board.length;
        
        if(board[x][y]==-1){
            boolean found=true;
            for(int i=0;i<N;i++){
            // System.out.println(i+" "+x+" "+y+" "+board[x][i]+" "+board[i][y]);
             if(board[x][i]==value) return false;
             if(board[i][y]==value) return false;
            }

            int xx= (x/3)*3;
            int yy= (y/3)*3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    //System.out.println((xx+i)+" "+(yy+j));
                    if(board[xx+i][yy+j]==value) return false; 
                }
            }
            return found;
        }
        else return false;
    }


}
