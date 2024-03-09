package SlidingWindow;

public class MaxConsecutive1s {
    int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
    int k=2;
    public static void main(String[] args) {
        new MaxConsecutive1s();
    }

    MaxConsecutive1s(){
        System.out.println("Brut: "+longestOnes(nums, k));
        System.out.println("Efficient: "+longestOnesEfficient(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int N= nums.length,count=0,skipper=k,max=0;
        for(int i=0;i<N;i++){
                int j=i;
                count=0;
                skipper=k;
                while(j<N && (nums[j]==1 || (nums[j]==0 && --skipper>=0))) {
                    max= Math.max(++count,max);
                    j++;
                }
                
        }
        return max;
    }

    public int longestOnesEfficient(int[] nums, int k) {
        int N= nums.length,l=0,r=0;
        while(l<N && r<N){
            if(nums[r]==0) k--;
            
            if(k<0)
                k += 1-nums[l++];
            r++;
        }
        return r-l;
    }
}
