public class Palindrome {
    
    public static void main(String[] args) {
        new Palindrome();    
       }
   
       Palindrome(){
           int[] arr = {1,2,3,3,2,1};
        
           System.out.print(isPalindrome(arr, 0));
       }
   
       public boolean isPalindrome(int[] arr,int index){
           int N = arr.length;

           if(index >= N/2) return true;

            if(arr[index]!=arr[N-index-1]) return false;

            return isPalindrome(arr, index+1);
           
       }

   
   }
   