package arrays;

import java.util.HashMap;

public class CountSubarrayXOREqualsK {
    public static long subarrayXor(int nums[], int k) {

        /*
         * Count Subarrays with given XOR
         * 
         * Given an array of integers arr[] and a number k, count the number of
         * subarrays having XOR of their elements as k.
         * 
         * Examples:
         * 
         * Input: arr[] = [4, 2, 2, 6, 4], k = 6
         * Output: 4
         * Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4,
         * 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
         * Input: arr[] = [5, 6, 7, 8, 9], k = 5
         * Output: 2
         * Explanation: The subarrays having XOR of their elements as 5 are [5] and [5,
         * 6, 7, 8, 9]. Hence, the answer is 2.
         * Input: arr[] = [1, 1, 1, 1], k = 0
         * Output: 4
         * Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
         * 
         * Constraints:
         * 
         * 1 ≤ arr.size() ≤ 105
         * 0 ≤ arr[i] ≤105
         * 0 ≤ k ≤ 105
         * 
         * 
         * 
         * IN subarray sum k, we find sum of a subarray and checks whether the sum
         * equals to k or not if yes then we imcrement the count
         * In subarray XOR k, we To calculate cumulative xor of subarrays element, and
         * if it equals to k then we increment the count
         * 
         * The base logic of both problems is same
         * 
         * if preSum = x, desiredSum = k, then for a subarray to be valid there must be
         * Previous subarray which equals to preSUm as X - K, so that x-k + k = x, which
         * is the preSum at ith index
         * 
         * just like that
         * 
         * in subarray XOR k
         * if preXOR = x, desiredXOR = k, then for a subarray to be valid there must be
         * Previous subarray which preXOR as X ^ k, then only x^k^k = x which is the
         * preXOR at ith index
         * 
         * 
         */

        // optimal hashmap, prefix sum/XOR

        int len = nums.length;
        HashMap<Long, Long> exists = new HashMap<>();

        // base case -> subarray with XOR 0 is occured 1 time
        exists.put(0L, 1L);

        long preXOR = 0;
        long cnt = 0L;

        for (int i = 0; i < len; i++) {
            preXOR ^= (long) nums[i];

            long find = preXOR ^ (long) k;

            Long occurrences = exists.getOrDefault(find, 0L);

            cnt += occurrences;

            exists.put(preXOR, 1L + exists.getOrDefault(preXOR, 0L));
        }

        return cnt;
    }
}
