public class HouseRobber {
    int input[]={100};
    public static void main(String[] args) {
        new HouseRobber();
    }

    HouseRobber(){
        System.out.println(houseRobber(input));
    }

    public static long houseRobber(int[] valueInHouse) {
		int N = valueInHouse.length;	
        int elements[] = new int[N-1];
        int elements_new[] = new int[N-1];
        int dynamicBuffer[] = new int[N];
        int dynamicBuffer_new[] = new int[N];
          for( int i=0;i<N;i++){
              dynamicBuffer[i]=-1;
              dynamicBuffer_new[i]=-1;
               if(i<N-1)
                  elements_new[i]=valueInHouse[i];
              if(i==0)
                  continue;
              elements[i-1]=valueInHouse[i];
             
            
        }
        int first = maximumSumNonadjacent(N-2,elements,dynamicBuffer);
        int second = maximumSumNonadjacent(N-2,elements_new,dynamicBuffer_new);
        System.out.println(first+" ===== "+second);
        return Math.max(first,second);
	}	
    
     private static int maximumSumNonadjacent(int value,int elements[],int dynamicBuffer[]){
        if(value == 0) return elements[value];
        if(value <0) return 0;
        if(dynamicBuffer[value] !=-1) return dynamicBuffer[value];

        int take = elements[value] + maximumSumNonadjacent(value-2,elements,dynamicBuffer);
        int leave = maximumSumNonadjacent(value-1,elements,dynamicBuffer);

        dynamicBuffer[value] = Math.max(take,leave);
        return dynamicBuffer[value];
    }
}
