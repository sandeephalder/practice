public class CherryPickup {

    int N=4,NM=3;
    int MIN_NUMBER= -Integer.MIN_VALUE/2;
    int mask[] = {-1,0,1};

    CherryPickup(){
        int[][] arr = {{2,3,1,2},{3,4,20,2},{5,6,3,5},{1,1,1,1}};
        System.out.println("cherryPickupRecursive ==> " +cherryPickupRecursive(arr,0,0,N-1));
        int[][][] dp = new int[4][4][4];
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) for(int k=0;k<N;k++) dp[i][j][k]=-1;
        System.out.println("cherryPickupRecursiveDP ==> " +cherryPickupRecursiveDP(arr,0,0,N-1,dp));
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) for(int k=0;k<N;k++) dp[i][j][k]=MIN_NUMBER;
        System.out.println("cherryPickupIterativeDP ==> " +cherryPickupIterativeDP(arr,dp));
    }
    public static void main(String[] args) {
        new CherryPickup();
    }

    private int cherryPickupRecursive(int[][] arr,int x,int y1,int y2){
        if(y1 <0 || y2 <0 || y1 > N-1 || y2 > N-1) return MIN_NUMBER;
        if(x == N-1 ) {
            if(y1==y2) return arr[x][y1]; 
            else return arr[x][y1] + arr[x][y2];
        }
        int current=0,max= MIN_NUMBER;
        for(int i=0;i<NM;i++){
            for(int j=0;j<NM;j++){
               current = arr[x][y1]+cherryPickupRecursive(arr, x+1, y1+mask[i], y2+mask[j]);
                if(!( y1 == y2))  current += arr[x][y2];
                max= Math.max(current, max);
            }
        }
        return max;
    }



    private int cherryPickupRecursiveDP(int[][] arr,int x,int y1,int y2,int[][][] dp){
        if(y1 <0 || y2 <0 || y1 > N-1 || y2 > N-1) return MIN_NUMBER;
        if(x == N-1 ) {
            if(y1==y2) return arr[x][y1]; 
            else return arr[x][y1] + arr[x][y2];
        }
        if(dp[x][y1][y2]!=-1) return dp[x][y1][y2];
        int current=0,max= MIN_NUMBER;
        for(int i=0;i<NM;i++){
            for(int j=0;j<NM;j++){
               current = arr[x][y1]+cherryPickupRecursiveDP(arr, x+1, y1+mask[i], y2+mask[j],dp);
                if(!( y1 == y2))  current += arr[x][y2];
                max= Math.max(current, max);
            }
        }
        dp[x][y1][y2] =max;
        return dp[x][y1][y2];
    }

    private int cherryPickupIterativeDP(int[][] arr,int[][][] dp){
        dp[0][0][N-1]= arr[0][0]+arr[0][N-1];
        for(int x=0;x<N;x++){
            for(int y1=0;y1<N;y1++){
                for(int y2=0;y2<N;y2++){
                    int current=0,max= MIN_NUMBER;
                    for(int i=0;i<NM;i++){
                        for(int j=0;j<NM;j++){
                            if((y1+mask[i]) <0 || (y2+mask[j]) <0 || (y1+mask[i]) >=N || (y2+mask[j]) >=N) continue;
                            if(y1 <0 || y2 <0 || y1 > N-1 || y2 > N-1 || x<=0 || x> N-1) continue;
                            current = arr[x][y1]+dp[x-1][y1+mask[i]][y2+mask[j]];
                            if(!( y1 == y2))  current += arr[x][y2];
                            max= Math.max(current, max);
                            dp[x][y1][y2] = max;
                        }
                    }

                }
            }
        }
        int max = MIN_NUMBER;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) max = Math.max(max, dp[N-1][i][j]);
        return max;
    }
}
