public class MinimumCoinsToSum {
    public static void main(String[] args) {
        new MinimumCoinsToSum();
    }

    MinimumCoinsToSum(){
        int num[] ={1 ,2 ,3};
        int maxWeight=5,N=num.length;
         int result= findMinCoins(N-1, maxWeight, num, initBuffer(N, maxWeight));
         //if(result>=2147483647)
        // retrun -1;
         //else return result;
         System.out.println(result);
    }

    int[][] initBuffer(int M,int N){
        int[][] buffer = new int[M+1][N+1];
        for(int i =0;i<=M;i++)
        for(int j=0;j<=N;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    int findMinCoins(int index,int wt,int num[],int buffer[][]){
        
        if(index ==0) {
            if(wt % num[0] ==0) {
                System.out.println(index+" == "+wt+" == "+wt/num[0]);
                return wt/num[0];
            }
            
            return 25000;
        }
        if(buffer[index][wt] !=-1) return  buffer[index][wt];
        int take=25000,noTake=25000 ,result=0;
        
        noTake = findMinCoins(index-1, wt, num, buffer);

        if(wt>= num[index])
        take = 1+findMinCoins(index, wt-num[index], num,  buffer);

        result =  Math.min(take, noTake);
        System.out.println("Index ==> "+index+" noTake "+noTake+" take "+take+" Result===> "+result);
        buffer[index][wt]=result;
        return result;
    }
}
