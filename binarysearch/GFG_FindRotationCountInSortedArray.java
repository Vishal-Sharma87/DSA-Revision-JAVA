package binarysearch;

public class GFG_FindRotationCountInSortedArray {

    // Created at: 1 march 2026
    // Last revised at: 1 march 2026

    // link: https://www.geeksforgeeks.org/problems/rotation4723/1

    /*
     * Description
     * Find Kth Rotation
     * Difficulty: EasyAccuracy: 23.16%Submissions: 346K+Points: 2Average Time: 20m
     * Given an increasing sorted rotated array arr[] of distinct integers. The
     * array is right-rotated k times. Find the value of k.
     * Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2
     * times it will look like this:
     * After 1st Rotation : [9, 2, 4, 6]
     * After 2nd Rotation : [6, 9, 2, 4]
     * 
     * Examples:
     * 
     * Input: arr[] = [5, 1, 2, 3, 4]
     * Output: 1
     * Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is
     * [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
     * Input: arr = [1, 2, 3, 4, 5]
     * Output: 0
     * Explanation: The given array is not rotated.
     * Constraints:
     * 1 ≤ arr.size() ≤ 105
     * 1 ≤ arr[i] ≤ 107
     * 
     * 
     * 
     */
    // Method to solve the Problem
    public int findKRotation(int nums[]) {

        /*
         * approach
         * 
         * find the smallest value in the array and return its index
         * 
         * nums[] = [7,8,-15,-8,0,1,6]
         * 
         * minimum = -15
         * minIndex = 2
         * rotation count = minIndex = 2
         * 
         * // Time Complexity: O(logN)
         * // Space Complexity: Constant
         */
        int low = 0, high = nums.length - 1;

        int mid, mini = Integer.MAX_VALUE;

        if (nums[low] < nums[high])
            return 0;

        int minIndex = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            // chech whether the value at mid index is smaller than "mini" so far?
            if (nums[mid] < mini) {

                // we found a smaller value
                // store the idnex and update mini
                mini = nums[mid];
                minIndex = mid;
            }

            // check which half is sorted
            if (nums[low] <= nums[mid]) {
                // left half is sorted

                // chech whether the value at low index is samaller than "mini"?
                if (nums[low] < mini) {

                    // found a smaller value than mini in the left half
                    // store the index of low and update mini
                    mini = nums[low];
                    minIndex = low;
                }
                low = mid + 1;

            } else
                high = mid - 1;
        }
        return minIndex;
    }

}
