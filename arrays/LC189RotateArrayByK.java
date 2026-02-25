package arrays;

public class LC189RotateArrayByK {
    public void solve(int[] nums, int k) {

        // link : https://leetcode.com/problems/rotate-array/description/

        /**
         * the three possible solutions i can see is
         * a. run a loop for k, shift the values to the right by one index, for each
         * element of array
         * time :k*n
         * space :constant
         * 
         * b. get an array of same length
         * set i = 0 and j = k,
         * copy the value
         * copyArray[j] = array[i];
         * j = (j + 1) % sizeOfArray; -> to overcome the out of index problem
         * time :n,
         * space : n
         * 
         * c. get the partitionIndex sizeOfArray - k - 1;
         * reverse 0 -> partitionIndex
         * reverse partitionIndex + 1 -> size - 1
         * 
         * then reverse the whole array as one unit
         * 
         * time: 2*n ~ n
         * space : constant
         */

        if (nums.length <= 1) {
            return;
        }

        int len = nums.length;
        // * get the optimal k, as k can be very large,
        // and rotating the array after its size reults in repeatition of work
        k = k % len;

        int partitionIndex = len - k - 1;

        // * reverse 0 -> partitionIndex
        ArraysOfVishal.reverseArray(nums, 0, partitionIndex);

        // * reverse partitionIndex + 1 -> size - 1
        ArraysOfVishal.reverseArray(nums, partitionIndex + 1, len - 1);
        // * then reverse the whole array as one unit

        ArraysOfVishal.reverseArray(nums, 0, len - 1);

        // * time: 2*n ~ n
        // * space : constant

    }
}
