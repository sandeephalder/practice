public class PartitionSubsetMinDifferencerecursion {
    public static void main(String[] args) {
        new PartitionSubsetMinDifferencerecursion();
    }
    PartitionSubsetMinDifferencerecursion(){
        int input[] = {8, 6, 5},N=0,sum=0;
        N = input.length;
        for(int i=0;i<N;i++)
        sum += input[i];
        int[][] buffer = new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
        for(int j=0;j<=sum;j++)
            buffer[i][j]=-1;
        System.out.println(findSubsetSum(buffer,input,N-1,sum));
    }

    int findSubsetSum(int[][] buffer,int[] input,int index,int target){
        if(target ==0) return 0;
        if(index ==0) return target;
        if(buffer[index][target] != -1) return buffer[index][target];

        int take=Integer.MIN_VALUE,notake=0,result=0;

        notake = findSubsetSum(buffer,input, index-1, target);
        //if(target >= input[index])
        take = findSubsetSum(buffer,input, index-1, target-input[index]);
        result = Math.min(take , notake);
        buffer[index][target] = result;
        return result;
    }
}
 