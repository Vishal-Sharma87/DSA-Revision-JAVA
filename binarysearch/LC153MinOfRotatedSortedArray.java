package binarysearch;

public class LC153MinOfRotatedSortedArray {

    // Created at: 1-March-2026
    // Last revised at: 1-March-2026

    // link:
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

    /*
     * 153. Find Minimum in Rotated Sorted Array
     * Suppose an array of length n sorted in ascending order is rotated between 1
     * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     * 
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
     * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * 
     * Given the sorted rotated array nums of unique elements, return the minimum
     * element of this array.
     * 
     * You must write an algorithm that runs in O(log n) time.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     * 
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4
     * times.
     * Example 3:
     * 
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     * 
     * 
     * Constraints:
     * 
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * All the integers of nums are unique.
     * nums is sorted and rotated between 1 and n times.
     */

    /**
     * 
     * @param nums Rotated and Sorted array in which you want to find minimum
     * @return returns minimum in the array
     */
    public int findMin(int[] nums) {

        /*
         * approach
         * 
         * step 1:
         * calculate mid and update the mini by minimum of them
         * i.e., mini = Math.min(mini, nums[mid]);
         * 
         * step 2:
         * find the sorted half
         * if left is sorted -> means smallest value in range low-> mid is at low index,
         * so get the min of mini and nums[low]
         * move to right
         * 
         * else right is sorted so just move to left no updation required
         * beacuse mid-> high is sorted in non decreasing order so min of them will be
         * at mid, which we have alredy computed
         * 
         * TIME: O(logN)
         * space: constant;
         * 
         */

        int low = 0, high = nums.length - 1;
        int mid, mini = Integer.MAX_VALUE;

        if (nums[low] <= nums[high]) {
            // array is already sorted -> return the first value
            return Math.min(mini, nums[low]);
        }

        while (low <= high) {
            mid = low + (high - low) / 2;

            mini = Math.min(mini, nums[mid]);

            if (nums[low] <= nums[mid]) {
                mini = Math.min(mini, nums[low]);
                low = mid + 1;

            } else
                high = mid - 1;
        }
        return mini;
    }

}