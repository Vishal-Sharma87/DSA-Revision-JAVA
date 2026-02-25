package arrays;

import java.util.HashMap;

public class LC128LongestConsecutiveSequence {
    private int getCount(boolean[] vis, HashMap<Integer, Integer> valToIndex, int val, boolean isPos) {
        int count = 0;
        Integer index = valToIndex.getOrDefault(val, null);
        while (index != null && !vis[index]) {
            count++;
            vis[index] = true;
            val = isPos ? ++val : --val;
            index = valToIndex.getOrDefault(val, null);
        }
        return count;
    }

    public int longestConsecutive(int[] nums) {

        // optimal is yet to code

        // link:https://leetcode.com/problems/longest-consecutive-sequence/description/
        /*
         * 128. Longest Consecutive Sequence
         * Given an unsorted array of integers nums, return the length of the longest
         * consecutive elements sequence.
         * 
         * You must write an algorithm that runs in O(n) time.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [100,4,200,1,3,2]
         * Output: 4
         * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
         * Therefore its length is 4.
         * Example 2:
         * 
         * Input: nums = [0,3,7,2,5,8,4,6,0,1]
         * Output: 9
         * Example 3:
         * 
         * Input: nums = [1,0,1,2]
         * Output: 3
         * 
         * 
         * Constraints:
         * 
         * 0 <= nums.length <= 105
         * -109 <= nums[i] <= 109
         */

        int len = nums.length;

        if (len <= 1)
            return len;

        boolean[] vis = new boolean[len];
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < len; i++) {
            valToIndex.put(nums[i], i);
        }

        int i = 0, maxLen = 1;

        while (i < len) {
            if (vis[i]) {
                i++;
                continue;
            }
            int val = nums[i];
            vis[i] = true;

            int posCount = getCount(vis, valToIndex, val + 1, true);
            int negCount = getCount(vis, valToIndex, val - 1, false);

            int cnt = 1 + posCount + negCount;
            maxLen = Math.max(cnt, maxLen);
            i++;
        }
        return maxLen;
    }
}
