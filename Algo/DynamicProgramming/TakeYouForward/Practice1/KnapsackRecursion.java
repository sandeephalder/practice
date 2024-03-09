public class KnapsackRecursion {
    public static void main(String[] args) {
        new KnapsackRecursion();
    }

    KnapsackRecursion(){
        int weight[] ={1 ,2 ,4, 5};
        int value[] ={5, 4, 8, 6};
        int maxWeight=5,N=weight.length;
         int result= maxValue(N-1, maxWeight, weight, value, initBuffer(N, maxWeight));
         System.out.println(result);
        
    }
    int[][] initBuffer(int M,int N){
        int[][] buffer = new int[M+1][N+1];
        for(int i =0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    int maxValue(int index,int wt,int weight[],int value[],int buffer[][]){
        if(index <=0) {
            if(wt >= weight[0]) return value[0];
            return 0;
        }
        if(buffer[index][wt] !=-1) return  buffer[index][wt];
        int take=Integer.MIN_VALUE,noTake=0,result=0;
        
        noTake = maxValue(index-1, wt, weight, value, buffer);

        if(wt>= weight[index])
        take = value[index] + maxValue(index-1, wt-weight[index], weight, value, buffer);

        result =  Math.max(take, noTake);
        buffer[index][wt]=result;
        return result;
    }
}
