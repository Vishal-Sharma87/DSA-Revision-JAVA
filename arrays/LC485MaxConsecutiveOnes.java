package arrays;

public class LC485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        // link :https://leetcode.com/problems/max-consecutive-ones/

        int len = nums.length;

        int maxi = 0;
        int i = 0;

        while (i < len) {
            if (nums[i] == 0) {
                i++;
                continue;
            }

            int cnt = 1;
            int j = i + 1;

            while (j < len && nums[j++] == 1)
                cnt++;
            maxi = Math.max(maxi, cnt);
            i = j;
        }

        return maxi;
    }
}
