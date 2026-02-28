package binarysearch;

public class LC81RotatedSortedArraySearch2 {

    // Find target exists in nums or not if it is then true else false

    public boolean exists(int[] nums, int target) {
        /*
         * APPROACH
         * 
         * When a sorted array conatines duplicate and is rotated then
         * 
         * there can be two scenarios
         * 1111112111
         * low mid and high have same value-> just shrink the halves by one index
         * else both halves adjacent to "mid" are not always sorted, but either of them
         * is
         * always sorted
         * 
         * 1.find the sorted one
         * 2.check whether the target lies is sorted part or not
         * 3.eliminate the other half accordingly
         * 
         * 
         * TIME : O(logN)
         * SPACE : constant
         */

        int low = 0, high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // if value at low pointer is smaller or equals to the value of mid pointer then
            // the half from low to mid is sorted
            if (nums[low] <= nums[mid]) {
                // check if the target lies in low to mid(value at low must be included)
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // the half from mid to high is sorted
                // check if the target lies in mid to hight(value at high must be included)
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;

    }
}
