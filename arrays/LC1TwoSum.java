package arrays;

import java.util.HashMap;

public class LC1TwoSum {
    public int[] twoSum(int[] nums, int k) {

        // link: https://leetcode.com/problems/two-sum/
        /*
         * BRUTE FORCE TWO LOOPS
         * vector<int>idx(2,-1);
         * for(int i=0; i<nums.size()-1; i++)
         * {
         * for(int j=i+1; j<nums.size(); j++)
         * {
         * if(nums[i]+nums[j]==target)
         * {
         * idx[0]=i;
         * idx[1]=j;
         * return idx;
         * }
         * }
         * }
         * return idx;
         * 
         * better id we want indices-> sort the array and two-pointer
         */
        int len = nums.length;

        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Integer index = valToIndex.getOrDefault((k - nums[i]), null);

            if (index != null && i != index)
                return new int[] { i, index };
            valToIndex.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
