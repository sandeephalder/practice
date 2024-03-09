package binarysearch;

public class KthElement {

    int[] nums1 = {1 ,2, 3, 5, 6};
    int[] nums2 = {4 ,7 ,8 ,9 ,100  };
    int k=6;
    public static void main(String[] args) {
        new KthElement();
    }

    KthElement(){
        System.out.println(kthElement(nums1, nums2, k));
    }

    public double kthElement(int[] nums1, int[] nums2,int k) {
        int l1=nums1.length,l2=nums2.length,l=l1+l2,i=0,i1=0,i2=0,current=0;
        while(i<l){
            if(i1>=l1) current=nums2[i2++];
            else if(i2>=l2) current=nums1[i1++];
            else if(nums1[i1]>nums2[i2]) current=nums2[i2++];
            else current=nums1[i1++];
            if(i==k-1)
                return current;
            i++;
        }
        return -1;
    }
}
