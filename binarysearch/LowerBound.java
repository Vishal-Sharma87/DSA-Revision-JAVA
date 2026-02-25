package binarysearch;

public class LowerBound {
    // link: https://www.geeksforgeeks.org/problems/implement-lower-bound/1
    /*
     * The lower bound of a number is defined as the smallest index in the sorted
     * array where the element is greater than or equal to the given number.
     */

    /*
     * Implement Lower Bound
     * Given a sorted array arr[] and a number target, the task is to find the lower
     * bound of the target in this given array.
     */
    /**
     * @param nums:         array of integer in which the search for lower bound is
     *                      executed
     * @param start:        first index of search space (inclusive)
     * @param end:          last index of search space (inclusive)
     * @param target:       value to search
     * @param defaultValue: the value to return if not found
     */
    public int findLowerBound(int[] nums, int start, int end, int target) {
        if (start > end)
            throw new IllegalArgumentException("The search space must be valid");

        int lb = -1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else {
                lb = mid;
                end = mid - 1;
            }
        }

        return lb;
    }

}
