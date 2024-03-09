public class MaxSumNonAdjacentElementsIterative {
    int elements[] = {2,1,9,1,10};
    int N= elements.length;
    int dynamicBuffer[] = new int[N];
    public static void main(String[] args) {
        new MaxSumNonAdjacentElementsIterative();
    }

    MaxSumNonAdjacentElementsIterative(){
        for( int i=0;i<dynamicBuffer.length;i++){
            dynamicBuffer[i]=-1;
        }
        System.out.println(maximumSumNonadjacent(elements.length-1));
    }

    private int maximumSumNonadjacent(int value){
       /*  if(value == 0) return elements[value];
        if(value <0) return 0;
        if(dynamicBuffer[value] !=-1) return dynamicBuffer[value];

        int take = elements[value] + maximumSumNonadjacent(value-2);
        int leave = maximumSumNonadjacent(value-1);

        dynamicBuffer[value] = Math.max(take,leave); */
        dynamicBuffer[0]=elements[0 ];

        for(int i=1;i<N;i++){
            int take = elements[i] ;
            if(i>1)
            take += dynamicBuffer[i-2];
            int leave = dynamicBuffer[i-1];
            dynamicBuffer[i] = Math.max(take,leave);
        }

        return dynamicBuffer[value];
    }
}
