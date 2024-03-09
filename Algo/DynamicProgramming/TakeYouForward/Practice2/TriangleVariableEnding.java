public class TriangleVariableEnding {
    TriangleVariableEnding(){
        int[][] arr ={{1},{2,3},{3,6,7},{8,9,6,10}};
        int[][] dp = new int[4][4];
        System.out.println(" triangleVariableEndingRecursion==> "+triangleVariableEndingRecursion(arr,0,0));
        for(int i=0;i<arr.length;i++) for(int j=0;j<arr[3].length;j++) dp[i][j]=-1;
        System.out.println(" triangleVariableEndingRecursionDP==> "+triangleVariableEndingRecursionDP(arr,0,0,dp));
        for(int i=0;i<arr.length;i++) for(int j=0;j<arr[3].length;j++) dp[i][j]=-0;
        System.out.println(" triangleVariableEndingIterativeDP==> "+triangleVariableEndingIterativeDP(arr,0,0,dp));
    }

    public static void main(String[] args) {
        new TriangleVariableEnding();
    }

    private int triangleVariableEndingRecursion(int[][] arr,int x,int y){
            if(x==arr.length-1) return arr[x][y];

            int down=0,right=0;

            down = arr[x][y]+triangleVariableEndingRecursion(arr, x+1, y);
            right = arr[x][y]+triangleVariableEndingRecursion(arr, x+1, y+1);

            return Math.min(down, right);
    }

    private int triangleVariableEndingRecursionDP(int[][] arr,int x,int y,int[][] dp){
        if(x==arr.length-1) return arr[x][y];
        if(dp[x][y]!=-1) return dp[x][y];
        int down=0,right=0;

        down = arr[x][y]+triangleVariableEndingRecursionDP(arr, x+1, y,dp);
        right = arr[x][y]+triangleVariableEndingRecursionDP(arr, x+1, y+1,dp);
        dp[x][y] = Math.min(down, right);
        return dp[x][y];    
    }

    private int triangleVariableEndingIterativeDP(int[][] arr,int x,int y,int[][] dp){
        for(int i=0;i<4;i++) dp[3][i]= arr[3][i];
        for(int i=2;i>=0;i--){
            
            for(int j=i;j>=0;j--){
                int down=Integer.MAX_VALUE/2,right=Integer.MAX_VALUE/2;
                down = arr[i][j]+dp[i+1][j];
                right = arr[i][j]+dp[i+1][j+1];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];    
    }
}
