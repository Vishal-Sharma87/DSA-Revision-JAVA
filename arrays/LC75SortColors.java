package arrays;

public class LC75SortColors {
    public void sort(int[] nums) {
        // link: https://leetcode.com/problems/sort-colors/description/
        /*
        
         * 75. Sort Colors
         * Given an array nums with n objects colored red, white, or blue, sort them
         * in-place so that objects of the same color are adjacent, with the colors in
         * the order red, white, and blue.
         * 
         * We will use the integers 0, 1, and 2 to represent the color red, white, and
         * blue, respectively.
         * 
         * You must solve this problem without using the library's sort function.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [2,0,2,1,1,0]
         * Output: [0,0,1,1,2,2]
         * Example 2:
         * 
         * Input: nums = [2,0,1]
         * Output: [0,1,2]
         * 
         * 
         * Constraints:
         * 
         * n == nums.length
         * 1 <= n <= 300
         * nums[i] is either 0, 1, or 2.
         * 
         * 
         * Follow up: Could you come up with a one-pass algorithm using only constant
         * extra space?
         */
        int len = nums.length;
        if (len <= 1)
            return;

        int i = 0, j = len - 1, k = 0;

        while (k <= j) {
            if (nums[k] == 0) {

                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                i++;
                k++;
            } else if (nums[k] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j--;
            } else
                k++;
        }
    }
}
