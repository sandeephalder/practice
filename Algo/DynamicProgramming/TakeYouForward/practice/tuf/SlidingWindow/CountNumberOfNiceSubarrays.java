package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    int nums[] = {1,1,2,1,1},k = 3;
    public static void main(String[] args) {
        new CountNumberOfNiceSubarrays();
    }

    CountNumberOfNiceSubarrays(){
        System.out.println(numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
       int n = nums.length;

        // Create a map to store the count of prefix sums encountered
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1); // Initialize with count 1 for an empty subarray

        int sum = 0; // Initialize sum of odd numbers to 0
        int res = 0; // Initialize the result count to 0

        // Iterate through the input array
        for (int i = 0; i < n; i++) {
            // Check if the current number is odd
            if (nums[i] % 2 == 1) {
                sum += 1; // Increment the sum of odd numbers
            }

            // Check if the complement (sum - k) exists in the map
            if (cnt.containsKey(sum - k)) {
                res += cnt.get(sum - k); // Increment the result count by the value at complement
            }

            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1); // Increment the count of the current sum in the map
        }

        return res; 
    }
}
