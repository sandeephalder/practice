import java.util.Arrays;

public class WildCardMatching {
    public static void main(String[] args) {
        new WildCardMatching();
    }
    WildCardMatching(){
        String string="abc",pattern="*";
        int i=string.length(),j=pattern.length();
        System.out.println(findWildCardMatching(string, pattern, i-1, j-1));
        int[][] dp = new int[i][j];
        for(int[] d: dp) Arrays.fill(d, -1);
        System.out.println(findWildCardMatchingDP(string, pattern, i-1, j-1,dp));
        System.out.println(findWildCardMatchingIterativeDP(string, pattern, i, j));
        
    }

    private boolean findWildCardMatching(String string,String pattern,int i,int j){
        boolean result=false;
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0) {
            while(j!=0) if(pattern.charAt(j--)!='*') return false;
            return true;
        }
        if(string.charAt(i)== pattern.charAt(j) || pattern.charAt(j)=='?') {
            result= findWildCardMatching(string, pattern, i-1, j-1);
        }
        if(pattern.charAt(j)=='*'){
            result = findWildCardMatching(string, pattern, i-1, j)
            ||
            findWildCardMatching(string, pattern, i, j-1);
        }
        return result;
    }

    private boolean findWildCardMatchingDP(String string,String pattern,int i,int j,int[][] dp){
        boolean result=false;
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0) {
            while(j!=0) if(pattern.charAt(j--)!='*') return false;
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1?true:false;
        if(string.charAt(i)== pattern.charAt(j) || pattern.charAt(j)=='?') {
            result= findWildCardMatching(string, pattern, i-1, j-1);
        }
        if(pattern.charAt(j)=='*'){
            result = findWildCardMatching(string, pattern, i-1, j)
            ||
            findWildCardMatching(string, pattern, i, j-1);
        }
        dp[i][j] = result?1:0;
        return result;
    }

    private boolean isAllStars(String pattern,int i){
        while(i!=0) if(pattern.charAt(--i)!='*') return false;
        return true;
    }

    private boolean findWildCardMatchingIterativeDP(String string,String pattern,int I,int J){
        boolean result=false;
   

        int[][] dp = new int[I+1][J+1];
        for(int[] d: dp) Arrays.fill(d,0);

        dp[0][0]=1;

        for (int j = 1; j <= J; j++) {
            dp[0][j] = 1;
          }
          for (int i = 1; i <= I; i++) {
            dp[i][0] = isAllStars(string, i)?1:0;
          }

          
        for(int i=1;i<=I;i++){
            for(int j=1;j<=J;j++){
                if(string.charAt(i-1)== pattern.charAt(j-1) || pattern.charAt(j-1)=='?') {
                    result= dp[i-1][j-1]==1?true:false;
                }
                if(pattern.charAt(j-1)=='*'){
                    result = dp[i-1][j]==1?true:false || dp[i][ j-1]==1?true:false;
                }
                else dp[i][j] = 0;
                dp[i][j] = result?1:0;
            }
        }
       
        return dp[I][J]==1?true:false ;
    }
}
