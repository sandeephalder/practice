public class PartitionEqualSubsetSumRecursion {
    public static void main(String[] args) {
        new PartitionEqualSubsetSumRecursion();
    }

    PartitionEqualSubsetSumRecursion(){
        int input[] = {5, 6, 5, 11, 6},N=0,sum=0;
        N = input.length;
        for(int i=0;i<N;i++)
        sum += input[i];
        if(sum %2==1)
        return ;
        sum /=2;
        int[][] buffer = new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
        for(int j=0;j<=sum;j++)
            buffer[i][j]=-1;
        System.out.println(findSubsetSum(buffer,input,N-1,sum));
       
    }

    boolean findSubsetSum(int[][] buffer,int[] input,int index,int target){
        if(target ==0) return true;
        if(index ==0) return input[0]==target;
        if(buffer[index][target] != -1) return buffer[index][target] == 1;

        boolean take=false,notake=false,result=false;

        notake = findSubsetSum(buffer,input, index-1, target);
        if(target >= input[index])
        take = findSubsetSum(buffer,input, index-1, target-input[index]);
        result = take || notake;
        buffer[index][target] = result==true?1:0;
        return result;
    }
}
