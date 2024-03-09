package tuf.recursion;
public class SudukuSolver1 {
    public static void main(String[] args) {
        new SudukuSolver1();
    }

    SudukuSolver1(){
        
        fillBoard(board,0,0);
        printArray(board);
        System.out.println();
      //  System.out.println(checkIfFits(board, 0, 3, 6));
    }

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

        private void printArray(int[][] board){
            int N = board.length;
            System.out.println();
            for(int i=0;i<N ;i++){
                System.out.println();
                for(int j=0;j<N ;j++)
                  System.out.print(" "+board[i][j]);
            }
        }

        private boolean fillBoard(int[][] board,int x,int y){
            int N = board.length;
            
        
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j]==-1)
                    {
                        for(int value=1;value<10;value++){
                           
                            if(checkIfFits(board, i, j, value)){
                                board[i][j]=value;
                                if(fillBoard(board,i,j)) return true;
                                else board[i][j]=-1;
                            }
                         
                        }
                        return false;
                    }
                   
                }
            }
            return true;
        }


    private boolean checkIfFits(int[][] board,int x,int y,int value){
        int N = board.length;

        if(board[x][y]==-1){

            for(int i=0;i<N;i++){
                if(board[x][i]==value) return false;
                if(board[i][y]==value) return false;
            }

            int xx= (x/3)*3;
            int yy= (y/3)*3;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++)
                if(board[xx+i][yy+j]==value) return false;
               
            }
        }

        return true;
    }
        
    }


