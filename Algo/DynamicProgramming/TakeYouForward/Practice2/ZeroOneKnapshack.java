import java.util.Arrays;
import java.util.Currency;

public class ZeroOneKnapshack {
    ZeroOneKnapshack(){
        int[] weight = {3,4,5};
        int[] value = {30,50,60};
        int maxTotalWeight = 8;

        System.out.println(" findZeroOneKnapshackRecursive===> "+findZeroOneKnapshackRecursive(weight, value, weight.length-1, maxTotalWeight, 0));

        int[][] dp = new int[weight.length][maxTotalWeight+1];
        for(int i=0;i<weight.length;i++) Arrays.fill(dp[i],-1);
        System.out.println(" findZeroOneKnapshackRecursiveDP===> "+findZeroOneKnapshackRecursiveDP(weight, value, weight.length-1, maxTotalWeight, 0,dp));

        for(int i=0;i<weight.length;i++) Arrays.fill(dp[i],0);
        System.out.println(" findZeroOneKnapshackIterativeDP===> "+findZeroOneKnapshackIterativeDP(weight, value, weight.length-1, maxTotalWeight, 0,dp));

        System.out.println(" findZeroOneKnapshackIterative===> "+findZeroOneKnapshackIterative(weight, value, weight.length-1, maxTotalWeight, 0));
    }

    public static void main(String[] args) {
        new ZeroOneKnapshack();
    }
    
    private int findZeroOneKnapshackRecursive(int[] weight,int[] value,int n,int maxwt,int totalvalue){
            if(n==0) {
                if(maxwt>=weight[n]) return value[n];
                else return 0;
            }

            if(maxwt==0) return 0;

            int take =0,nontake=0;

            if(maxwt>=weight[n]) take = findZeroOneKnapshackRecursive(weight, value, n-1, maxwt-weight[n],totalvalue+value[n])  +value[n];
            nontake = findZeroOneKnapshackRecursive(weight, value, n-1, maxwt,totalvalue);

            return Math.max(take,nontake);
    }

    private int findZeroOneKnapshackRecursiveDP(int[] weight,int[] value,int n,int maxwt,int totalvalue,int[][] dp){
        if(n==0) {
            if(maxwt>=weight[n]) return value[n];
            else return 0;
        }

        if(maxwt==0) return 0;

        if(dp[n][maxwt]!=-1) return dp[n][maxwt];

        int take =0,nontake=0;

        if(maxwt>=weight[n]) take = findZeroOneKnapshackRecursiveDP(weight, value, n-1, maxwt-weight[n],totalvalue+value[n],dp)  +value[n];
        nontake = findZeroOneKnapshackRecursiveDP(weight, value, n-1, maxwt,totalvalue,dp);

        dp[n][maxwt]= Math.max(take,nontake);

        return dp[n][maxwt];
    }

    private int findZeroOneKnapshackIterativeDP(int[] weight,int[] value,int n,int maxwt,int totalvalue,int[][] dp){

        for(int i=0;i<maxwt+1;i++) dp[0][i] = value[0];
       
        for(int i=1;i<weight.length;i++){
            for(int wt=1;wt<=maxwt;wt++){
                int take =Integer.MIN_VALUE/2,nontake=Integer.MIN_VALUE/2;

                if(wt>=weight[i]) take = dp[i-1][wt-weight[i]]+value[i];
                nontake = dp[i-1][wt];
        
                dp[i][wt]= Math.max(take,nontake);
            }
        }
        return dp[n][maxwt];
    }

    private int findZeroOneKnapshackIterative(int[] weight,int[] value,int n,int maxwt,int totalvalue){

        int[] current = new int[maxwt+1];
        int[] prev = new int[maxwt+1];

        for(int i=0;i<maxwt+1;i++) prev[i] = value[0];
       
        for(int i=1;i<weight.length;i++){
            for(int wt=1;wt<=maxwt;wt++){
                int take =Integer.MIN_VALUE/2,nontake=Integer.MIN_VALUE/2;

                if(wt>=weight[i]) take = prev[wt-weight[i]]+value[i];
                nontake = prev[wt];
        
                current[wt]= Math.max(take,nontake);
            }
            prev = current;
        }
        return prev[maxwt];
    }
}
