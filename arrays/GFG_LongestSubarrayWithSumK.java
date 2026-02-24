package arrays;

import java.util.HashMap;

public class GFG_LongestSubarrayWithSumK {

    public int getLength(int[] nums, int k) {
        //
        /*
         * method 1 brute force:
         * generate all subarray and find and check if their sum is quals to k
         * if yes then keep the max(len, len(curr sub array))
         * 
         * 
         * 
         * int len = nums.length;
         * int maxLen = 0;
         * 
         * for (int i = 0; i < len; i++) {
         * for (int j = i; j < len; j++) {
         * if (isSubarraySumEqualsK(nums, i, j, k)) {
         * maxLen = Math.max(maxLen, j - i + 1);
         * }
         * }
         * }
         * 
         * return maxLen;
         * 
         * time o(n ^ 3)
         * soace constant
         * 
         * method 2: better
         * 
         * the one observation during subarray growth is that
         * the sub array loop starts from i -> j
         * and j increments one by one,
         * we can keep a sum at the start of new i as 1,
         * 
         * and after one increment of j, we can add the val[j] to the sum
         * in this way we can track the sum in constant time
         * 
         * and the time required for sum calcumation of subarray can be discarded
         * 
         * 
         * int len = nums.length;
         * int maxLen = 0;
         * 
         * for (int i = 0; i < len; i++) {
         * int sum = 0;
         * for (int j = i; j < len; j++) {
         * sum += nums[j];
         * if (sum == k)
         * maxLen = Math.max(maxLen, j - i + 1);
         * }
         * }
         * 
         * return maxLen;
         * 
         * 
         * 
         * method 3: using prefix sum and hashmap
         * the logic is simple
         * 
         * 
         * while iterating over the array we will build the hashmap
         * 
         * we will compute the prefix sum and store it in a hashmap io
         * key = prefix sum til ith index
         * value = i
         * 
         * **** -> we will use putIfAbsent beacuse newer i will override the previous
         * one if any, and will ultimatly result in shorten length
         * 
         * now if the prefix sum itself is quals to k, then we will assign mxLen = i + 1
         * because we are movinf from 0 to len
         * and prefix sum is the sum till 0 -> i, means no longer than ith index is
         * possible
         * 
         * but if it not then we will check
         * if (prefixSum - k ) is present in hashmap or not
         * why?
         * 
         * suppose the prefix sum at ith index is -> X
         * then
         * suppose their is a subarray that ends at ith index, so to end at ith index,
         * previously there were a prefixsum which was equals to y, then for a valid
         * subarray
         * x-y must be equal to k (valid subarray condition)
         * 
         * so y beacomes x - k
         * hence we will find (prefixsumAtI - k) and will get index of it
         * 
         * 
         * if the index is not null, then we found a valid subarray
         * 
         * so just update the maxLen accordingly
         * 
         * time: 0(nlogn) in worst case when fethching value from hashmap needs logn
         * time
         * (rare, only possible in collision of value)
         * spwace: n
         */
        int len = nums.length;
        HashMap<Integer, Integer> prefixSumToIndex = new HashMap<>();

        int preSum = 0, maxLen = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            prefixSumToIndex.putIfAbsent(preSum, i);
            if (preSum == k) {
                maxLen = i + 1;
                continue;
            }

            Integer index = prefixSumToIndex.getOrDefault(preSum - k, null);

            if (index != null) {
                maxLen = Math.max(maxLen, i - index);
            }
        }

        return maxLen;

    }

    public  boolean isSubarraySumEqualsK(int[] nums, int start, int end, int target) {

        int subarraySum = getSumOfSubArray(nums, start, end);

        return subarraySum == target;

    }

    public  int getSumOfSubArray(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
