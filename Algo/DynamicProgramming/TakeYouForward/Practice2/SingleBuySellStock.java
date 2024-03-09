public class SingleBuySellStock {
    public static void main(String[] args) {
        new SingleBuySellStock();
    }
    SingleBuySellStock(){
      int[] stock = {7,1,5,3,6,4};
      int min=Integer.MAX_VALUE,profit=Integer.MIN_VALUE;
      
      for(int i=0;i<stock.length;i++){
        min = Math.min(min, stock[i]);
        profit = Math.max(profit, stock[i]-min);
      }
      System.out.println(profit);
    }
}
