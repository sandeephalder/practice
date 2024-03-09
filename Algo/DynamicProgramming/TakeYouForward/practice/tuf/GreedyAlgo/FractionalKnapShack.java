package GreedyAlgo;

import java.util.Arrays;

public class FractionalKnapShack {

    int weight[] = {50 ,40, 90, 120 ,10, 200 },
    value[] = {40 ,50, 25, 100, 30, 45},a=200;
    
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
        
        @Override
        public String toString() {
            return "Item [value=" + value + ", weight=" + weight + "]";
        }

        
    }

    public static void main(String[] args) {
        new FractionalKnapShack();
    }

    public Item[] sort(int[] value,int[] weight){
        int N= value.length;
        Item[] result = new Item[N];
        for(int i=0;i<N;i++){
            result[i]= new Item(value[i], weight[i]);
        }
       
        return result;
    }

    FractionalKnapShack(){
        System.out.println(fractionalKnapsack(a, sort(value, weight), value.length));
    }

    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        Arrays.sort(arr,(ths,that)->Double.compare((double)that.value/that.weight, (double)ths.value/ths.weight));
        print(arr);
        double result=0.0;
        for(int i=0;i<n;i++){
            //System.out.println("Start ==> weight = "+arr[i].weight+" arr[i].value "+arr[i].value);
            if(w-arr[i].weight>=0){
                 w-= arr[i].weight;
                 result+=arr[i].value;
                 //System.out.println("\nMatch ==> weight = "+arr[i].weight+" arr[i].value "+arr[i].value+"result "+result);
            }
            else{
                if(w>0){
                    
                    double fraction = ((double)((double)arr[i].value/(double)arr[i].weight))*W;
                    System.out.println("MisMatch ===> W = "+W+"fraction "+fraction+"result "+result);
                    result+=fraction;
                    w=0;
                }
                
            }
        }
        return result;
    }

    public void print(Item[] arr){
        System.out.println();
        for(Item i:arr) System.out.print(" ==> "+i);
    }
}
