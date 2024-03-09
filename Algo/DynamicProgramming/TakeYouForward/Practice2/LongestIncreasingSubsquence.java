import java.util.Arrays;

public class LongestIncreasingSubsquence {
    LongestIncreasingSubsquence(){
        int arr[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsquence();
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        for(int i:nums) System.out.print(" ==> "+i);
        int counter=1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                counter++;
                max = Math.max(max, counter);
            }
            else counter=1;
        }
        return max;
    }
    
    public int longestConsecutive(int[] nums,int n,int prev) {
        if(n>=nums.length) return 0;
        
        int take =Integer.MIN_VALUE,nontake=Integer.MIN_VALUE;
        
        if(nums[n]-nums[prev]==1 || (prev==0 && n==0)){
            take = longestConsecutive(nums,n+1,n) + 1;
            System.out.println("take = "+take+" n= "+n);
        }
        else
        nontake = longestConsecutive(nums,n+1,n) ;
        
        return Math.max(take,nontake);
    }
}
