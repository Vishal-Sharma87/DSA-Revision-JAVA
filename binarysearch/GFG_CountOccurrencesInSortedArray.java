package binarysearch;

public class GFG_CountOccurrencesInSortedArray {
    // link:https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
    /*
     * Number of occurrence
     * Given a sorted array, arr[] and a number target, you need to find the number
     * of occurrences of target in arr[].
     * 
     * Examples :
     * 
     * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
     * Output: 4
     * Explanation: target = 2 occurs 4 times in the given array so the output is 4.
     * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
     * Output: 0
     * Explanation: target = 4 is not present in the given array so the output is 0.
     * Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
     * Output: 3
     * Explanation: target = 12 occurs 3 times in the given array so the output is
     * 3.
     * Constraints:
     * 1 ≤ arr.size() ≤ 106
     * 1 ≤ arr[i] ≤ 106
     * 1 ≤ target ≤ 106
     */

    /**
     * 
     * @param nums   Integer arrays in which the range need to find
     * @param target the value to find
     * @return return 0 if value is not present in the integer array
     */
    int countOccurrence(int[] nums, int target) {

        FindIndexOfTarget findIndex = new FindIndexOfTarget();
        int first = findIndex.find(nums, 0, nums.length - 1, target, true);
        int last = findIndex.find(nums, 0, nums.length - 1, target, false);

        return first == -1 ? 0 : last - first + 1;
    }
}
