package arrays;

public class LC493ReversePairs {

    // link:https://leetcode.com/problems/reverse-pairs/description/
    /*
     * 493. Reverse Pairs
     * Given an integer array nums, return the number of reverse pairs in the array.
     * 
     * A reverse pair is a pair (i, j) where:
     * 
     * 0 <= i < j < nums.length and
     * nums[i] > 2 * nums[j].
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,3,2,3,1]
     * Output: 2
     * Explanation: The reverse pairs are:
     * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
     * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
     * Example 2:
     * 
     * Input: nums = [2,4,3,5,1]
     * Output: 3
     * Explanation: The reverse pairs are:
     * (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
     * (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
     * (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 5 * 104
     * -231 <= nums[i] <= 231 - 1
     */

    private int mergeSort(int[] nums, int s, int e) {
        int cnt = 0;
        if (s >= e)
            return cnt;

        // calculate mid
        int mid = s + (e - s) / 2;

        // Sort the left half
        cnt += mergeSort(nums, s, mid);

        // Sort the right half
        cnt += mergeSort(nums, mid + 1, e);

        int i, j = mid + 1, index = 0;

        for (i = s; i <= mid; i++) {
            while (j <= e && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            cnt += j - mid - 1;
        }
        i = s;
        j = mid + 1;

        // Create merged array, to store elements of nums in sorted manner
        int[] merged = new int[e - s + 1];

        // push elements to merged array
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j])
                merged[index++] = nums[i++];
            else {
                merged[index++] = nums[j++];
            }
        }

        // j exhausted
        while (i <= mid) {
            merged[index++] = nums[i++];
        }

        // i exhausted
        while (j <= e) {
            merged[index++] = nums[j++];
        }

        index = s;

        for (int val : merged) {
            nums[index++] = val;
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
