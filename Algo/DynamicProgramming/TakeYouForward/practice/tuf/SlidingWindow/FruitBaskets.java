package SlidingWindow;

import java.util.HashMap;

public class FruitBaskets {
    static int[] arr = {34,
        26 ,25, 22 ,18 ,31 ,19, 18, 25 ,10 ,18, 13 ,13, 8, 14, 14,10, 1, 25 ,5, 30, 32, 24 ,22 ,25 ,24 ,
        2, 7, 27, 3, 28 ,30, 20, 5, 14 };
    public static void main(String[] args) {
        System.out.println("Brut: "+findMaxFruits(arr, arr.length));
        System.out.println("Efficient: "+findMaxFruitsEfficient(arr, arr.length));
    }

    public static int findMaxFruitsEfficient(int []arr, int n) {
         int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            while(map.size() > 2) {
                int mapVal = map.get(arr[i]);
                
                if(mapVal == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], mapVal - 1);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    public static int findMaxFruits(int []arr, int N) {
        int count=0;
        for(int i=0;i<N;i++){
            int firstType=-1,firstCount=0,secondType=-2,secondCount=0;
            for(int j=i;j<N;j++){
                if(firstType==-1 && secondType!=firstType ){
                    firstType=arr[j];
                    firstCount++;
                }
                else if(secondType==-2 && firstType!=arr[j]){
                    secondType=arr[j];
                    secondCount++;
                }
                else if(arr[j]==firstType) firstCount++;
                else if(arr[j]==secondType) secondCount++;
                else break;
               // System.out.println("i= "+i+" j= "+j+" F type "+firstType+"first = "+firstCount+" second = "+secondCount);
            }
            count=Math.max(count, firstCount+secondCount);
        }

       return count;
    }
}
