public class SudukuSolver {

    public static void main(String[] args) {
        new SudukuSolver();
    }
    SudukuSolver(){
        int[][] suduku = {
            {8,-1,1,6,5,9,2,3,4},
            {4,5,9,3,1,2,6,8,7},
            {3,2,6,4,7,8,5,9,1},
            {9,3,4,7,2,5,1,6,8},
            {6,1,2,9,8,3,7,4,5},
            {7,8,5,1,6,4,9,2,3},
            {2,4,3,5,1,9,8,7,6},
            {1,6,8,2,4,7,3,5,9},
            {-1,9,7,8,3,6,4,1,2}
        };

        
        generateSuduku(suduku, 0, 9);
    }

    public void generateSuduku(int[][] suduku,int y,int SIZE){
        if(y >= SIZE) return;
        if( checkSudukuFilled(suduku)){
        
            printArrays(suduku);
            return;
        }

        for(int i=0;i<SIZE;i++){
            if(suduku[i][y]==-1)
            for(int value=1;value<10;value++)
            if(checkvalidSudukuRows(suduku, i, y, SIZE, value)){
                suduku[i][y]=value;
                generateSuduku(suduku, y+1, SIZE);
                suduku[i][y]=-1;
            }
        }
    }

    public boolean checkSudukuFilled(int[][] suduku){
        for(int i=0;i<9;i++)
        for(int j=0;j<9;j++)
        if(suduku[i][j] == -1) return false;
        return true;
    }

    public boolean checkvalidSudukuRows(int[][] suduku,int  x,int y,int SIZE,int value){
        int startX=x/3,startY=y/3,endX=startX+3,endY=startY+3;
        if(suduku[x][y]!=-1) return false;
        for(int i=0;i<SIZE;i++){
            if(suduku[i][y] == value) return false;
            if(suduku[x][i] == value) return false;
        }
        for(int i=startX;i<endX;i++)
        for(int j=startY;j<endY;j++)
        if(suduku[i][j] == value) return false;
        return true;
    }

    private void printArrays(int arr[][]){
        System.out.println("Print Array ===> ");
        for(int i[]: arr)
            printArray(i);;
        System.out.println();
    }

    private void printArray(int arr[]){
        System.out.println();
        for(int i: arr)
            System.out.print("==>"+i);
        System.out.println();
    }
}
