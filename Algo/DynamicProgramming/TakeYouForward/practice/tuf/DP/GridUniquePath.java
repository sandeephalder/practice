package tuf.DP;

import java.util.Arrays;

public class GridUniquePath {

    int HEIGHT=3,WIDTH=3;
    int[][] dp = new int[HEIGHT+1][WIDTH+1];
    
    GridUniquePath(){
        resetVisited(dp);
        System.out.println(findGridUniquePath(HEIGHT, WIDTH,dp));
        System.out.println(findGridUniquePathIterative());
        System.out.println(findGridUniquePathIterativeEfficient());
    }

    private void resetVisited(int[][] dp){
        for(int i=0;i<=HEIGHT;i++) Arrays.fill(dp[i],-1);
        
    }

    public static void main(String[] args) {
        new GridUniquePath();
    }


    private int findGridUniquePath(int height,int width,int[][] dp){

        if(height == 0 && width == 0)    return 1;
        
        if(height <0 ||  width<0) return 0;

        if(dp[height][width]!=-1) return dp[height][width];
        int x=0,y=0;
        if(height>0)
        x= findGridUniquePath(height-1, width,dp);
        if(width>0)
        y= findGridUniquePath(height, width-1,dp);
        dp[height][width] = x+y;
        return dp[height][width];
    }

    private int findGridUniquePathIterative(){
        resetVisited(dp);

        dp[0][0]=1;
      
        int x=0,y=0;
        for(int height=0;height<=HEIGHT;height++){
            
            for(int width=0;width<=WIDTH;width++){
                x=0;
                y=0;
                if(height==0 && width==0) {
                    dp[0][0]=1;
                    continue;
                }
                if(height>0)
                x= dp[height-1][width];
                if(width>0)
                y= dp[height][width-1];
                dp[height][width] = x+y;
            }
        }
        
        return dp[HEIGHT][WIDTH];
    }

    private int findGridUniquePathIterativeEfficient(){
       int[] current = new int[WIDTH+1];
       int[] previous = new int[WIDTH+1];

     

        int x=0,y=0;
        for(int height=0;height<=HEIGHT;height++){
            
            for(int width=0;width<=WIDTH;width++){
                x=0;
                y=0;
                if(height==0 && width==0) {
                    current[0]=1;   
                    continue;
                }
                if(height>0)
                x= previous[width];
                if(width>0)
                y= current[width-1];
                current[width] = x+y;
                //System.out.println(x+y);
                previous=current;
            }
        }
        
        return current[WIDTH];
    }
}
