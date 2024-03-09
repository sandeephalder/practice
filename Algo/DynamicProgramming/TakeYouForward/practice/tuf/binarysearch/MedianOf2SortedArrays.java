package binarysearch;

public class MedianOf2SortedArrays {
    int[] nums1 = {0};
    int[] nums2 = {};
    public static void main(String[] args) {
        new MedianOf2SortedArrays();
    }

    MedianOf2SortedArrays(){
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length,l=l1+l2,i=0,i1=0,i2=0,m1=0,current=0;
        while(i<l){
            if(i1>=l1) current=nums2[i2++];
            else if(i2>=l2) current=nums1[i1++];
            else if(nums1[i1]>nums2[i2]) current=nums2[i2++];
            else current=nums1[i1++];
            if(l%2==1){
                if(i==l/2) return current;
            }else{
                if(i==(l/2-1)) m1=current;
                if(i==(l/2)) return ((double)current+(double)m1)/2;
            }
            i++;
        }
        return -1;
    }
}
