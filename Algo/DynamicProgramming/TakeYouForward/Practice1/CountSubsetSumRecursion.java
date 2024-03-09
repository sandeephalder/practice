public class CountSubsetSumRecursion {
    public static void main(String[] args) {
        new CountSubsetSumRecursion();
    }

    CountSubsetSumRecursion(){
        int input[] = {1, 2, 2, 3},N=0,sum=3;
        N = input.length;
        int[][] buffer = new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
        for(int j=0;j<=sum;j++)
            buffer[i][j]=-1;
        System.out.println(countSubsetSum(buffer,input,N-1,sum));
        
    }

    int countSubsetSum(int[][] buffer,int[] input,int index,int target){
        if(target ==0) return 1;
        if(index ==0) return input[index]==target?1:0;
        if(buffer[index][target] != -1) return buffer[index][target];

        int take=0,notake=0,result=0;

        notake = countSubsetSum(buffer,input, index-1, target);
        if(target >= input[index])
        take = countSubsetSum(buffer,input, index-1, target-input[index]);
        result = take + notake;
        buffer[index][target] = result;
        return result;
    }
}
