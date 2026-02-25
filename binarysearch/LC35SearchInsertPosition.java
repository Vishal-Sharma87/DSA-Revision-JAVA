package binarysearch;

public class LC35SearchInsertPosition {

    // link: https://leetcode.com/problems/search-insert-position/description/

    /*
     * 35. Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the
     * index if the target is found. If not, return the index where it would be if
     * it were inserted in order.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     * 
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     * 
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     */

    /**
     * 
     * @param nums   arrays of integer in which we want to insert target
     * @param target value to insert
     * @return insertPos, the variable which store the best possible index in array
     *         for target
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        /*
         * the variable to store best index intialized with 0, in case all values are
         * greater than target
         */
        int insertPos = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                insertPos = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return insertPos;
    }

}
