public class MazeObstaclesRecursion {
    int M=3,N=3;

    
    public static void main(String[] args) {
        new MazeObstaclesRecursion();
    }
    MazeObstaclesRecursion(){
        int path[][]={{0, 0 ,0},{0, -1, 0},{0, 0, 0}};
        int[][] buffer =new  int[M+1][N+1];
        for(int i=0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        int results = traverseMaze(M-1,N-1,path,buffer);
        System.out.println(results);
    }

    private int traverseMaze(int x,int y,int[][] path,int[][] buffer){
        if(x==0 && y==0) return 1;
        if(x<0 || y <0) return 0;
        if(path[x][y] ==-1) return 0;
        if(buffer[x][y]!=-1) return buffer[x][y];
        int up,left,max;

        up= traverseMaze(x-1, y, path, buffer);
        left =  traverseMaze(x, y-1, path, buffer);
        max = up + left;
        buffer[x][y]=max;
        return max;
    }
}
