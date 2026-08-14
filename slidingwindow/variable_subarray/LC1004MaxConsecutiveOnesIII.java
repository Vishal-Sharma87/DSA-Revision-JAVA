package slidingwindow.variable_subarray;

// Created at: 24-April-2026
// Last revised at: 24-April-2026
// Link: https://leetcode.com/problems/max-consecutive-ones-iii/
// Time Complexity: O(N)
// Space Complexity: O(1)

/*
 * Problem Description:
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1s if you can flip at most k 0s.
 *
 * Example:
 *   Input:  nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 *   Output: 6   // flip index 9 and 10 → [1,1,1,0,0,1,1,1,1,1,1]
 *
 *   Input:  nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 *   Output: 10
 *
 * Constraints:
 *   - 1 <= nums.length <= 10^5
 *   - nums[i] is either 0 or 1
 *   - 0 <= k <= nums.length
 */

/*
 * Approaches:
 *
 * 1. Brute Force
 *    Idea    : Try every subarray, count zeros inside, track max length where zeros <= k
 *    Time    : O(N^2)
 *    Space   : O(1)
 *    Drawback: Too slow for N = 10^5
 *
 * 2. Sliding Window — shrinking (while loop)
 *    Idea    : Expand right; when flips > k, shrink from left using a while loop
 *              until the window is valid again
 *    Time    : O(2N) — each element can be visited twice (once by r, once by l)
 *    Space   : O(1)
 *    Drawback: Shrinks the window on violation — wastes time when we only care
 *              about windows larger than the current best
 *
 * 3. ★ Sliding Window — fixed-size slide (if statement)
 *    Idea    : Replace the shrink loop with a single if — when flips > k, slide
 *              the window forward by 1 (move l and r together) instead of collapsing it.
 *              The window never shrinks; it only grows or slides.
 *    Time    : O(N) — r and l each move exactly N times, no inner loop
 *    Space   : O(1)
 *    Key Insight: We only care about windows strictly larger than mxLen. Once a
 *                 window of size W is invalid, we never need a window smaller than W —
 *                 so sliding (not shrinking) is enough to find the next valid window of W+1.
 */

public class LC1004MaxConsecutiveOnesIII {

    /*
     * Method to solve:
     * 1. Expand r — if nums[r] == 0, increment flips
     * 2. If flips > k, the window is invalid — slide l forward by 1.
     * If nums[l] was 0, decrement flips before moving
     * 3. At this point window size is either the same or larger than before —
     * update mxLen
     * 4. Advance r
     */

    /**
     * Returns the maximum number of consecutive 1s achievable with at most k
     * zero-flips.
     *
     * @param nums binary integer array
     * @param k    maximum number of 0s that can be flipped
     * @return length of the longest valid window
     */
    public int longestOnes(int[] nums, int k) {

        int len = nums.length;

        int l = 0;
        int r = 0;
        int mxLen = 0;
        int flips = 0;

        while (r < len) {

            if (nums[r] == 0)
                flips++;

            // slide instead of shrink — window only grows, never collapses
            if (flips > k) {
                if (nums[l] == 0)
                    flips--;
                l++;
            }

            // window is at least as large as before — check if it's a new best
            if (r - l + 1 > mxLen) {
                mxLen = r - l + 1;
            }

            r++;
        }

        return mxLen;
    }
}