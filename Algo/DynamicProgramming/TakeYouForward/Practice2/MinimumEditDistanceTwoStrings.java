import java.util.Arrays;

public class MinimumEditDistanceTwoStrings {

    public static void main(String[] args) {
        new MinimumEditDistanceTwoStrings();
    }

    MinimumEditDistanceTwoStrings(){
        String s1= "horse",s2="ros";
        int i= s1.length(),j=s2.length();
        System.out.println(findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j-1));
        int[][] dp = new int[i][j];
        for(int[] d:dp) Arrays.fill(d, -1);
        System.out.println(findMinimumEditDistanceTwoStringsRecursiveDP(s1, s2, i-1, j-1,dp));
        System.out.println(findMinimumEditDistanceTwoStringsIterativeDP(s1, s2, i, j));
    }

    private int findMinimumEditDistanceTwoStringsRecursive(String s1,String s2,int i,int j){
        int result=0,insert=0,edit=0,delete=0;
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)){
            result = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j-1);

        }
        else{

            insert = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i, j-1);
            edit = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j-1);
            delete = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j);
            result = Math.min(Math.min(edit,delete),insert)+1;
        }
        return result;
    }

    private int findMinimumEditDistanceTwoStringsRecursiveDP(String s1,String s2,int i,int j,int[][] dp){
        int result=0,insert=0,edit=0,delete=0;
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            result = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j-1);
            
        }
        else{

            insert = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i, j-1);
            edit = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j-1);
            delete = findMinimumEditDistanceTwoStringsRecursive(s1, s2, i-1, j);
            result = Math.min(Math.min(edit,delete),insert)+1;
        }
        dp[i][j]=result;
        return result;
    }

    private int findMinimumEditDistanceTwoStringsIterativeDP(String s1,String s2,int I,int J){
        int result=0,insert=0,edit=0,delete=0;
        int[][] dp = new int[I+1][J+1];
        for(int[] d:dp) Arrays.fill(d, 0);

        //if(i<0) return j+1;
        //if(j<0) return i+1;
        for(int i=0;i<I;i++) dp[i][0]=i;
        for(int j=0;j<J;j++) dp[0][j]=j;
        
        for(int i=1;i<=I;i++){
            for(int j=1;j<=J;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    result = dp[i-1][j-1];
                    
                }
                else{
        
                    insert = dp[i][j-1];
                    edit = dp[i-1][j-1];
                    delete = dp[i-1][j];
                    result = Math.min(Math.min(edit,delete),insert)+1;
                }
                dp[i][j]=result;
            }
        }

        
        return dp[I][J];
    }

}
