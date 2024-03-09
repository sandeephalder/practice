public class RodCuttingRecursion {
    public static void main(String[] args) {
        new RodCuttingRecursion();
    }

    RodCuttingRecursion(){
        int price[]={2 ,5 ,7, 8, 10};
        int n=5;
        int result = cutRod(price,price.length-1, n,n,initBuffer(price.length, n));
        System.out.println(result);
    }

    int[][] initBuffer(int N,int K){
        int[][] buffer = new int[N+1][K+1]; 
        for(int i =0;i<=N;i++)
        for(int j=0;j<=K;j++)
        buffer[i][j]=-1;
        return buffer;
    }

    public int cutRod(int price[], int n,int rod,int R,int[][] buffer) {
       
        if(n ==0){
            return rod*price[0];
        }
        if(buffer[n][rod]!=-1) return buffer[n][rod];
        int pick=-2500000,nonPick=-2500000,result=0;

        nonPick = cutRod(price, n-1, rod,R,buffer);
        int rodLength = n+1;
        if(rodLength <=rod)
        pick = price[n]+cutRod(price, n,rod-rodLength,R,buffer);

        result = Math.max(pick, nonPick) ;
        buffer[n][rod]=result;
		return result;
	}
}
