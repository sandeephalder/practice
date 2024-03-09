package Arrays;

import java.util.Arrays;

public class MergeTwoArraysWithoutExtraSpace {

    int[] nums1 = {4,0,0,0,0,0}, nums2 = {1,2,3,5,6};
    int m=1,n=nums2.length;

    public static void main(String[] args) {
        new MergeTwoArraysWithoutExtraSpace();
    }

    MergeTwoArraysWithoutExtraSpace(){
        merge1(nums1, m, nums2, n);
        print(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        
        int l=0,r=0;
        for(int i=0;i<m;i++){
            if(l>=m || r>=n) break;
            if(nums1[l]>nums2[r]){
                while(nums1[l]>nums2[++r]);
                int temp = nums1[l];
                    nums1[l] = nums2[r];
                    nums2[r]=temp;
                
            }
            
            l++;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
       
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr){
            System.out.print("["+i+"],");
        }
}
}
