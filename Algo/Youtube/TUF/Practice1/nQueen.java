public class nQueen {
    public static void main(String[] args) {
        new nQueen();
    }

    nQueen(){   
        int[][] arr = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        //System.out.println("Answer:"+checkIfFits(arr, 1, 3, 4, 4));
        buildNQueen(arr, 0, 0, 4, 4);

        
    }

    private void buildNQueen(int[][] arr,int x,int y,int X,int Y){
        if(x>= X || y >= Y) {
            printArrays(arr);
            return;
        }


        for(int i=0;i<Y;i++){
            if(checkIfFits(arr, i, y, X, Y))
            {
                arr[i][y]=1;
                buildNQueen(arr, x, y+1, X, Y);
                arr[i][y]=0;
            }
        }
    }

    private boolean checkIfFits(int[][] arr,int x,int y,int X,int Y){
        for(int i=0;i<arr.length;i++){
            if(arr[i][y] == 1) return false;
            if(arr[x][i] == 1) return false;
            if(((x+i) <  X && (y+i) < Y) && arr[x+i][y+i] ==1) return false;
            if(((x-i) >= 0 && (y+i) < Y) && arr[x-i][y+i] ==1) return false;
            if(((x+i) <  X && (y-i) >=0) && arr[x+i][y-i] ==1) return false;
            if(((x-i) >=0 && (y-i) >=0) && arr[x-i][y-i] ==1) return false;
        }

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
