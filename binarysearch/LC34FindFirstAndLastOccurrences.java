package binarysearch;

public class LC34FindFirstAndLastOccurrences {

    // link:
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    /*
     * 34. Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the
     * starting and ending position of a given target value.
     * 
     * If target is not found in the array, return [-1, -1].
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * 
     * Input: nums = [5,7,7,8,8,10], target =
     * Output: [-1,-1]
     * Example 3:
     * 
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * 
     * 
     * Constraints:
     * 
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     */

    /**
     * 
     * @param nums   Integer array in which searching is executed
     * @param target Value to search in integer array
     * @param start  first index of range
     * @param end    last index of range
     * @return returns an array of length 2 where first value is the first *
     *         Occurrence of target and the second value is last occurrence of the
     *         target deafult is -1, -1
     */
    public int[] searchRange(int[] nums, int target, int start, int end) {
        FindIndexOfTarget findIndex = new FindIndexOfTarget();
        // the first method call searches the first index of target
        // the second method call searches the last index of target
        return new int[] {
                findIndex.find(nums, 0, nums.length - 1, target, true),
                findIndex.find(nums, 0, nums.length - 1, target, false) };
    }

}
