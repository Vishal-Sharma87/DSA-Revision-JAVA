package arrays;

public class GFG_CountInversion {
    // link:https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    /*
     * Count Inversions
     * Difficulty: MediumAccuracy: 16.93%Submissions: 756K+Points: 4
     * Given an array of integers arr[]. You have to find the Inversion Count of the
     * array.
     * Note : Inversion count is the number of pairs of elements (i, j) such that i
     * < j and arr[i] > arr[j].
     * 
     * Examples:
     * 
     * Input: arr[] = [2, 4, 1, 3, 5]
     * Output: 3
     * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1),
     * (4, 3).
     * Input: arr[] = [2, 3, 4, 5, 6]
     * Output: 0
     * Explanation: As the sequence is already sorted so there is no inversion
     * count.
     * Input: arr[] = [10, 10, 10]
     * Output: 0
     * Explanation: As all the elements of array are same, so there is no inversion
     * count.
     * Constraints:
     * 1 ≤ arr.size() ≤ 105
     * 1 ≤ arr[i] ≤ 104
     */

    private  int mergeSort(int[] nums, int s, int e) {
        int cnt = 0;
        if (s >= e)
            return cnt;

        // calculate mid
        int mid = s + (e - s) / 2;

        // Sort the left half
        cnt += mergeSort(nums, s, mid);

        // Sort the right half
        cnt += mergeSort(nums, mid + 1, e);

        // Create merged array, to store elements of nums in sorted manner
        int[] merged = new int[e - s + 1];

        int i = s, j = mid + 1, index = 0;

        // push elements to merged array
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j])
                merged[index++] = nums[i++];
            else {
                // found a inversion,
                // so all elements in nums from ith index to index mid will also be greater than
                // nums[j]
                cnt += mid - i + 1;
                merged[index++] = nums[j++];

            }
        }

        // j exhausted
        while (i <= mid) {
            merged[index++] = nums[i++];
        }

        // i exhausted
        while (j <= e) {
            merged[index++] = nums[j++];
        }

        // Copyback elements of merged array to original array
        for (i = 0; i < index; i++) {
            nums[i + s] = merged[i];
        }

        // return the cnt
        return cnt;
    }

     int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);

    }
}
