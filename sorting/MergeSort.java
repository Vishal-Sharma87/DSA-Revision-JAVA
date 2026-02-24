package sorting;

public class MergeSort {
    public void mergeSort(int[] nums, int s, int e) {
        if (s >= e)
            return;

        // calculate mid
        int mid = s + (e - s) / 2;

        // Sort the left half
        mergeSort(nums, s, mid);

        // Sort the right half
        mergeSort(nums, mid + 1, e);

        // Create merged array, to store elements of nums in sorted manner
        int[] merged = new int[e - s + 1];

        int i = s, j = mid + 1, index = 0;

        // push elements to merged array
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j])
                merged[index++] = nums[i++];
            else {
                merged[index++] = nums[j++];
            }
        }

        // copy remaining left elements
        while (i <= mid) {
            merged[index++] = nums[i++];
        }

        // copy remaining right elements
        while (j <= e) {
            merged[index++] = nums[j++];
        }

        index = s;
        for (int val : merged) {
            nums[index++] = val;
        }
    }
}
