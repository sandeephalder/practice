import javax.lang.model.util.ElementScanner14;

public class GridUniquepathSourceToDestination {

    int gridSize =4;
    GridUniquepathSourceToDestination(){
        System.out.println(" gridUniquepathSourceToDestinationRecursive===> "+gridUniquepathSourceToDestinationRecursive(gridSize-1, gridSize-1));
        int[][] dp = new int[gridSize][gridSize];
        for(int i=0;i<gridSize;i++) for(int j=0;j<gridSize;j++) dp[i][j]=-1;
        System.out.println(" gridUniquepathSourceToDestinationRecursiveDP===> "+gridUniquepathSourceToDestinationRecursiveDP(gridSize-1, gridSize-1,dp));

        for(int i=0;i<gridSize;i++) for(int j=0;j<gridSize;j++) dp[i][j]=0;
        System.out.println(" gridUniquepathSourceToDestinationRecursiveDP===> "+gridUniquepathSourceToDestinationIterationDP(gridSize-1, gridSize-1,dp));

        System.out.println(" gridUniquepathSourceToDestinationRecursive===> "+gridUniquepathSourceToDestinationIteration(gridSize-1, gridSize-1));
    }

    public static void main(String[] args) {
        new GridUniquepathSourceToDestination();
    }


    private int gridUniquepathSourceToDestinationRecursive(int x,int y){
        if(x==0 && y==0) return 1;
        if(x<0 || y <0) return 0;
        int left=0,up=0;

        left = gridUniquepathSourceToDestinationRecursive(x, y-1);
        up = gridUniquepathSourceToDestinationRecursive(x-1, y);

        return left+up;
    }



    private int gridUniquepathSourceToDestinationRecursiveDP(int x,int y,int[][] dp){
        if(x==0 && y==0) return 1;
        if(x<0 || y <0) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        int left=0,up=0;

        left = gridUniquepathSourceToDestinationRecursiveDP(x, y-1,dp);
        up = gridUniquepathSourceToDestinationRecursiveDP(x-1, y,dp);
        dp[x][y] = left+up;
        return dp[x][y];
    }

    private int gridUniquepathSourceToDestinationIterationDP(int x,int y,int[][] dp){
       
       
        for(int i=0;i<gridSize;i++){
            for(int j=0;j<gridSize;j++){
                int left=0,up=0;
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    if(j>0)left = dp[i][j-1];
                    if(i>0)up = dp[i-1][j];
                    dp[i][j] = left+up;
                }
               
            }
        }

        return dp[x][y];
    }

    private int gridUniquepathSourceToDestinationIteration(int x,int y){
       
      
       int[] prev= new int[gridSize];
        for(int i=0;i<gridSize;i++){
            int[] curr= new int[gridSize];
            for(int j=0;j<gridSize;j++){
                int left=0,up=0;
                if(i==0 && j==0) curr[j]=1;
                else{
                    if(j>0)left = curr[j-1];
                    if(i>0)up = prev[j];
                    curr[j] = left+up;
                }
               
            }
            prev=curr;
        }

        return prev[gridSize-1];
    }
}
