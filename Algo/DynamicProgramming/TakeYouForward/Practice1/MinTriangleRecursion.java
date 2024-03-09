public class MinTriangleRecursion {
    public static void main(String[] args) {
        new MinTriangleRecursion();
    }
    MinTriangleRecursion(){
        int path[][] ={{1},{2,3},{3,6,7},{8,9,6,10}},N=0,M=0,buffer[][];
        M= path.length;
        N= path[M-1].length;
        buffer = new int[M+1][N+1];
        int results = findPath(M,0,0,path,initBuffer(M,N,buffer));
        System.out.println(results);
    }

    int[][] initBuffer(int M,int N,int[][] buffer){
        for(int i =0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    int findPath(int M,int m,int n,int[][]path,int[][] buffer){
        if(m>=M-1 || n >=M-1) return path[m][n];
        if(buffer[m][n] !=-1) return buffer[m][n];
        int down = 0, right =0,min = 0;

        down = findPath(M, m+1, n, path, buffer);
        right = findPath(M, m+1, n+1, path, buffer);
        min = Math.min(down, right)+ path[m][n];
        buffer[m][n] = min;
        return min;
    }
}
