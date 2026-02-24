package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GFG_FindMissingAndRepeatingNumber {

    // link:https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
    /*
     * Missing And Repeating
     * Difficulty: EasyAccuracy: 24.83%Submissions: 684K+Points: 2Average Time: 30m
     * Given an unsorted array arr[] of size n, containing elements from the range 1
     * to n, it is known that one number in this range is missing, and another
     * number occurs twice in the array, find both the duplicate number and the
     * missing number.
     * 
     * Examples:
     * 
     * Input: arr[] = [2, 2]
     * Output: [2, 1]
     * Explanation: Repeating number is 2 and the missing number is 1.
     * Input: arr[] = [1, 3, 3]
     * Output: [3, 2]
     * Explanation: Repeating number is 3 and the missing number is 2.
     * Input: arr[] = [4, 3, 6, 2, 1, 1]
     * Output: [1, 5]
     * Explanation: Repeating number is 1 and the missing number is 5.
     * Constraints:
     * 2 ≤ n ≤ 106
     * 1 ≤ arr[i] ≤ n
     */

    ArrayList<Integer> findTwoElement(int nums[]) {
        // code here

        // better using sort
        int len = nums.length;
        if (len <= 1) {
            return null;
        }

        int missing = -1, repeating = -1;

        HashSet<Integer> exists = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (exists.contains(nums[i]))
                repeating = nums[i];
            else
                exists.add(nums[i]);
        }

        for (int val = 1; val <= len; val++) {
            if (!exists.contains(val)) {
                // val is not present in the set
                missing = val;
                break;
            }
        }
        return new ArrayList<>(List.of(repeating, missing));
    }
}
