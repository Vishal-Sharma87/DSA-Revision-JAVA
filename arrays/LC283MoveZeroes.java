package arrays;

public class LC283MoveZeroes {
    public void solve(int[] nums) {

        // link: https://leetcode.com/problems/move-zeroes/

        if (nums.length <= 0)
            return;

        int len = nums.length;
        int nextIndexOfNonZeroElement = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                ArraysOfVishal.swap(nums, nextIndexOfNonZeroElement, i);
                nextIndexOfNonZeroElement++;
            }
        }
    }
}
