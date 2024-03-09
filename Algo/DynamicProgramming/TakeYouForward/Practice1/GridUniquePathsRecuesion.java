public class GridUniquePathsRecuesion {
    int x=2,y=2;
    public static void main(String[] args) {
        new GridUniquePathsRecuesion();
    }

    GridUniquePathsRecuesion(){
        int buffer[][] = new int[x][y];
        for(int i=0;i<x;i++)
        for(int j=0;j<y;j++)
        buffer[i][j]=-1;
        System.out.print("Result :"+ findPaths(x-1,y-1,buffer));
    }

    private int findPaths(int x,int y,int buffer[][]){
        if(x==0 && y==0 ) return 1;
        if(x<0 || y<0) return 0;
        if(buffer[x][y]!=-1) return buffer[x][y];
        int left=0,up=0,max=0;

        left = findPaths(x, y-1,buffer);
        up = findPaths(x-1, y,buffer);
        max = left+up;
        buffer[x][y] = max;
        return max;
    }
}
