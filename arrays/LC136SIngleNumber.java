package arrays;

public class LC136SIngleNumber {
    public int singleNumber(int[] nums) {
        // link: https://leetcode.com/problems/single-number/
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
