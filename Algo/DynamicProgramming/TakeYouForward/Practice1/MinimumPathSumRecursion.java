public class MinimumPathSumRecursion {
    int input[][] = {{ 1, 2 ,3},{4 ,5, 4},{7 ,5 ,9}},M=3,N=3,buffer[][];

  


    public static void main(String[] args) {
        new MinimumPathSumRecursion();
    }
    MinimumPathSumRecursion(){
        int results= findMin(M-1,N-1,input,initBuffer());
        System.out.println(results);
    }

    int[][] initBuffer(){
        buffer = new int[M+1][N+1]; 
        for(int i =0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    int findMin(int x,int y,int[][] path,int[][]buffer){
        if(x==0 && y==0) return path[x][y];
        if(x<0 || y< 0) return Integer.MAX_VALUE;
        if(buffer[x][y]!=-1) return buffer[x][y];
        int up,left,min=0;
        up = findMin(x-1, y, path, buffer);
        left = findMin(x, y-1, path, buffer);
        min = Math.min(up, left) + path[x][y];
        buffer[x][y]=min;
        return min;
    }
}
