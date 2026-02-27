package binarysearch;

public class LC33RotatedSortedArraySearch {

    // https://leetcode.com/problems/search-in-rotated-sorted-array/

    /*
     * 33. Search in Rotated Sorted Array
     * There is an integer array nums sorted in ascending order (with distinct
     * values).
     * 
     * Prior to being passed to your function, nums is possibly left rotated at an
     * unknown index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
     * (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
     * and become [4,5,6,7,0,1,2].
     * 
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * 
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     * 
     * Input: nums = [1], target = 0
     * Output: -1
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * All values of nums are unique.
     * nums is an ascending array that is possibly rotated.
     * -104 <= target <= 104
     */

    /**
     * 
     * @param nums   Integer array in which searching is needed
     * @param target value to search
     * @return returns -1 if target is not present in the array, else returns index
     *         of target
     */
    public int search(int[] nums, int target) {

        /*
         * APPROACH
         * 
         * When a sorted array is rotated then both halves adjacent to "mid" are not
         * always sorted, but either of them is always sorted
         * 
         * 1.find the sorted one
         * 2.check whether the target lies is sorted part or not
         * 3.eliminate the other half accordingly
         * 
         * 
         * TIME : O(logN)
         * SPACE : constant
         */

        int low = 0, high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            // if value at low pointer is smaller or equals to the value of mid pointer then
            // the half from low to mid is sorted
            if (nums[low] <= nums[mid]) {
                // check if the target lies in low to mid(value at low must be included)
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // the half from mid to high is sorted
                // check if the target lies in mid to hight(value at high must be included)
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

}
