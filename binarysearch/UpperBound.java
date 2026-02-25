package binarysearch;

public class UpperBound {

    // link: https://www.geeksforgeeks.org/problems/implement-upper-bound/1
    /*
     * * The upper bound of a number is defined as the smallest index in the sorted
     * array where the element is greater than the given number.
     */

    /*
     * Implement Upper Bound
     * Given a sorted array arr[] and a number target, the task is to find the upper
     * bound of the target in this given array.
     * 
     * Note: If all the elements in the given array are smaller than or equal to the
     * target, the upper bound will be the length of the array.
     */
    /**
     * @param nums:         array of integer in which the search for lower bound is
     *                      executed
     * @param start:        first index of search space (inclusive)
     * @param end:          last index of search space (inclusive)
     * @param target:       value to search
     * @param defaultValue: the value to return if not found
     */
    public int findUpperBound(int[] nums, int start, int end, int target) {
        if (start > end)
            throw new IllegalArgumentException("The search space must be valid");

        int ub = -1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target)
                start = mid + 1;
            else {
                // found a greter or equal value store it's index and shring the space from
                // right
                ub = mid;
                end = mid - 1;
            }
        }

        return ub;
    }

}
