public class MinMaxFailingPathIterative {

    public static void main(String[] args) {
        new MinMaxFailingPathIterative();
    }

    MinMaxFailingPathIterative(){
        int[][] matrix = {{1, 2, 10, 4},{100, 3, 2, 1},{1 ,1 ,20, 2},{1, 2 ,2, 1}};
        int M=0,N=0;
        M= matrix.length;
        N= matrix[M-1].length;
        int[][] buffer = new int[M][N];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max= Math.max(max,findMinMaxPath(M, N, 0, i, matrix, buffer));
        }
       
    }

    int[][] initBuffer(int M,int N,int[][] buffer){
        for(int i =0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    int findMinMaxPath(int M,int N,int x,int y,int[][] matrix,int[][] buffer){
        /* if(x!=0 && (y <0 || y >N-1)) return Integer.MIN_VALUE;
        if(x >= M-1 ) return matrix[x][y];
        if(buffer[x][y] ==-1) return buffer[x][y];
        int left=0,down=0,right=0,max;

        left = findMinMaxPath(M, N, x+1, y-1, matrix, buffer);
        right = findMinMaxPath(M, N, x+1, y+1, matrix, buffer);
        down = findMinMaxPath(M, N, x+1, y, matrix, buffer);

        max = Math.max(Math.max(left,right),down) + matrix[x][y];
        buffer[x][y]=max; */
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                
            }
        }
        return buffer[x][y];
    }
}
