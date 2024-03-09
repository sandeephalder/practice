public class MaxSumNonAdjacentElements {
    int elements[] = {2,1,9,1,10};
    int dynamicBuffer[] = new int[elements.length];
    public static void main(String[] args) {
        new MaxSumNonAdjacentElements();
    }

    MaxSumNonAdjacentElements(){
        for( int i=0;i<dynamicBuffer.length;i++){
            dynamicBuffer[i]=-1;
        }
        System.out.println(maximumSumNonadjacent(elements.length-1));
       
    }

    private int maximumSumNonadjacent(int value){
        if(value == 0) return elements[value];
        if(value <0) return 0;
        if(dynamicBuffer[value] !=-1) return dynamicBuffer[value];

        int take = elements[value] + maximumSumNonadjacent(value-2);
        int leave = maximumSumNonadjacent(value-1);

        dynamicBuffer[value] = Math.max(take,leave);
        return dynamicBuffer[value];
    }
}
  