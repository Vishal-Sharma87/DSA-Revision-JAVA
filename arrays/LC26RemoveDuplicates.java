package arrays;

public class LC26RemoveDuplicates {
    public int solve(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        // get the prevUniqueVal
        int prevUniqueVal = nums[0];

        // set i and j
        int i = 1, j = 1;

        // iterate over array
        while (j < nums.length) {

            // if arr[j] is unique(greater than the prevUniqueVal swap it, increment i, j,
            // and update prevUniqueVal
            if (nums[j] > prevUniqueVal) {
                prevUniqueVal = nums[j];
                ArraysOfVishal.swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }

}
