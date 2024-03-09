package recursion;

public class CheckPalindrome {
    CheckPalindrome(){
        int[] arr = {2,2,3,4,4,3,2,1};
        System.out.println(isPalindrome(arr, 0));
    }
    public static void main(String[] args) {
        new CheckPalindrome();
    }

    private boolean isPalindrome(int[] arr,int index){
        int len = arr.length-1,mid= len/2;
        if(index>mid) return true;
        if(arr[index]!=arr[len-index]) return false;
        return isPalindrome(arr, index+1);
    }

  
}
