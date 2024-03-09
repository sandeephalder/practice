package DP2;

import java.util.Arrays;

public class PatternMatch {
    String s="abcb",p="a*?b";
    int N1=s.length(),N2=p.length();
    public static void main(String[] args) {
        new PatternMatch();
    }

    PatternMatch(){
        int[][] dp = new int[N1][N2];
        for(int i=0;i<N1;i++) Arrays.fill(dp[i],-1);
        System.out.println("Recursive: "+isMatch(s, p, N1-1, N2-1, dp));
        System.out.println("Iterative: "+isMatchIterative(s, p));
        System.out.println("Iterative Efficient: "+isMatchIterativeEfficient(s, p));
    }

    public boolean isMatch(String s, String p,int i1,int i2,int[][] dp) {
        if(i1<0 && i2<0) return true;
        if(i2<0 && i1 >=0) return false;
        if(i1<0 && i2>=0) {
            for(int i=0;i<i2;i++) if(p.charAt(i)!='*') return false;
            return true;
        }
        if(dp[i1][i2]!=-1) return dp[i1][i2]==1;
        if(s.charAt(i1)==p.charAt(i2) || p.charAt(i2)=='?'){
            dp[i1][i2]= isMatch(s, p, i1-1, i2-1, dp)?1:0;
        }
        else if(p.charAt(i2)=='*'){
            dp[i1][i2]=(isMatch(s, p, i1-1, i2, dp)||isMatch(s, p, i1, i2-1, dp))?1:0;
        }
        else dp[i1][i2]=0;
        return dp[i1][i2]==1;
    }
public boolean isMatchIterative(String s, String p) {
        boolean[][] dp = new boolean[N1+1][N2+1];
        dp[0][0]=true;
        for(int i=1;i<=N2;i++) dp[0][i]=false;
        for(int i=1;i<N1;i++) {
            for(int j=1;j<=i;j++) {
            
            if(p.charAt(j-1)=='*') dp[j][0]=true;
            else dp[j][0]=false;

            }

        }
        for(int i1=1;i1<=N1;i1++){
            for(int i2=1;i2<=N2;i2++){
                if(s.charAt(i1-1)==p.charAt(i2-1) || p.charAt(i2-1)=='?'){
                    dp[i1][i2]= dp[i1-1][i2-1];
                }
                else if(p.charAt(i2-1)=='*'){
                    dp[i1][i2]=dp[i1-1][i2]||dp[i1][i2-1];
                }
                else dp[i1][i2]=false;
            }
        }
        return dp[N1][N2];
    }

    public boolean isMatchIterativeEfficient(String s, String p) {
        boolean[] current = new boolean[N2+1];
        boolean[] previous = new boolean[N2+1];
       
        previous[0]=true;
        
       
               
        for(int i1=1;i1<=N1;i1++){

            for(int j=1;j<=i1;j++) {
            
            if(p.charAt(j-1)=='*') current[0]=true;
            else current[0]=false;
            }

            for(int i2=1;i2<=N2;i2++){
                if(s.charAt(i1-1)==p.charAt(i2-1) || p.charAt(i2-1)=='?'){
                    current[i2]= previous[i2-1];
                }
                else if(p.charAt(i2-1)=='*'){
                    current[i2]=previous[i2]||current[i2-1];
                }
                else current[i2]=false;
            }
            previous=current.clone();
        }
        return current[N2];
    }
}
