package binarysearch.onAnswers;

public class GFG_nthRoot {

    // Created at: 3 march 2026
    // Last revised at: 30 march 2026

    // link :https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1

    /*
     * Problem Description -> statement, example, constraints
     * 
     * Find nth root of m
     * Difficulty: MediumAccuracy: 25.06%Submissions: 256K+Points: 4Average Time:
     * 15m
     * You are given 2 numbers n and m, the task is to find n√m (nth root of m). If
     * the root is not integer then return -1.
     * 
     * Examples :
     * 
     * Input: n = 3, m = 8
     * Output: 2
     * Explanation: 23 = 8
     * Input: n = 3, m = 9
     * Output: -1
     * Explanation: 3rd root of 9 is not integer.
     * Input: n = 4, m = 16
     * Output: 2
     * Explanation: 24 = 16
     * Constraints:
     * 1 ≤ n ≤ 9
     * 0 ≤ m ≤ 20
     * 
     */

    // Method to solve the Problem
    public int nthRoot(int n, int x) {
        if (n <= 0)
            return -1;

        int low = 0;
        int high = x / n + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long val = (long) mid;
            for (int i = 1; i < n; i++) {
                val *= (long) mid;
                // val is already crossed the x, stop early
                if (val > x)
                    break;
            }
            // found a valid nth root return it
            if (val == (long) x)
                return mid;

            // mid is smaller -> search for bigger value
            if (val < (long) x) {
                low = mid + 1;
            } else {
                // mid is greater -> search for smaaler value
                high = mid - 1;
            }
        }
        // no nth root exixts return -1
        return -1;
    }

    // Time Complexity: O(n * log(x/n)) , (x/n) because at max we can go to high
    // Space Complexity: consatnt
}
