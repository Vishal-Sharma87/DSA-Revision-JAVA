package binarysearch;

public class BinarySearch {

    /**
     * @param nums:         array of integer in which the search is executed
     * @param start:        first index of search space (inclusive)
     * @param end:          last index of search space (inclusive)
     * @param target:       value to search
     * @param defaultValue: the value to return if not found
     */
    public int binarySearch(int[] nums, int start, int end, int target, int defaultValue) {
        if (start > end)
            throw new IllegalArgumentException("The search space must be valid");

        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return defaultValue;
    }
}
