public class SubSetSumToK {
    public static void main(String[] args) {
        new SubSetSumToK();
    }

    SubSetSumToK(){
        int input[] = {4,3,2,1},N=0,sum=5;
        N = input.length;
        int[][] buffer = new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
        for(int j=0;j<=sum;j++)
            buffer[i][j]=-1;
        System.out.println(hasSubsetSum(buffer,input,N-1,sum));
        
    }

    boolean hasSubsetSum(int[][] buffer,int[] input,int index,int target){
        if(target ==0) return true;
        if(index ==0) return input[0]==target;
        if(buffer[index][target] != -1) return buffer[index][target] == 1;

        boolean take=false,notake=false,result=false;

        notake = hasSubsetSum(buffer,input, index-1, target);
        if(target >= input[index])
        take = hasSubsetSum(buffer,input, index-1, target-input[index]);
        result = take || notake;
        buffer[index][target] = result==true?1:0;
        return result;
    }
}
