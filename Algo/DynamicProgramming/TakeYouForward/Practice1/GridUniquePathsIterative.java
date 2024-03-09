public class GridUniquePathsIterative {
    int x=2,y=2;
    public static void main(String[] args) {
        new GridUniquePathsIterative();
    }

    GridUniquePathsIterative(){
        int buffer[][] = new int[x+1][y+1];
  
        System.out.print("Result :"+ findPaths(buffer));
    }

    private int findPaths(int buffer[][]){
       
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++)
            {
                if(i==0 && j==0 ) buffer[i][j]=1;
                else{
                    int left=0,up=0;
                    if(j>0) left = buffer[i][j-1];
                    if(i>0) up = buffer[i-1][j];
                    buffer[i][j] = left+up;
                }
            }
        }

        
        return buffer[x-1][y-1];
    }
}
