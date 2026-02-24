
package arrays;

public class LC59MaximumSubarrayKadanesAlgo {
    public int maxSubArray(int[] nums) {

        // link:https://leetcode.com/problems/maximum-subarray/description/
        /*
         * 53. Maximum Subarray
         * Given an integer array nums, find the subarray with the largest sum, and
         * return its sum.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
         * Output: 6
         * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
         * Example 2:
         * 
         * Input: nums = [1]
         * Output: 1
         * Explanation: The subarray [1] has the largest sum 1.
         * Example 3:
         * 
         * Input: nums = [5,4,-1,7,8]
         * Output: 23
         * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
         * 
         * 
         * Constraints:
         * 
         * 1 <= nums.length <= 105
         * -104 <= nums[i] <= 104
         * 
         * 
         * Follow up: If you have figured out the O(n) solution, try coding another
         * solution using the divide and conquer approach, which is more subtle.
         */

        // brute force
        // O(n ^ 2)
        // int len = nums.length;
        // int maxSum = Integer.MIN_VALUE;

        // for (int i = 0; i < len; i++) {
        // int sum = 0;
        // for (int j = i; j < len; j++) {

        // sum += nums[j];
        // maxSum = Math.max(maxSum, sum);

        // }
        // }
        // return maxSum;

        // optimal KADANE'S ALGORITHM

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;

    }

    public void printMaximumSumSubArray(int[] nums) {
        if (nums.length == 0)
            return;
        int tempStart = -1;
        int start = -1, end = -1;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                // strating a new subarray, tempStart = i, to remember the start index
                tempStart = i;
            }

            sum += nums[i];

            if (sum > maxSum) {
                // found a better subArray
                maxSum = sum;
                // it is possible when sum >= 0 before addition on nums[i] to it
                start = tempStart;
                end = i;
            }

            if (sum < 0)
                sum = 0;
        }

        // print the array between start and end
        System.out.println("printing subarray with maximum sum:");

        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
}
