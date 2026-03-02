package binarysearch.onAnswers;

public class LC875BananaEating {

    // Created at: 3 march 2026
    // Last revised at: 3 march 2026

    // link :https://leetcode.com/problems/koko-eating-bananas/description/

    /*
     * Problem Description -> statement, example, constraints
     * 875. Koko Eating Bananas
     * Solved
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
     * piles[i] bananas. The guards have gone and will come back in h hours.
     * 
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
     * chooses some pile of bananas and eats k bananas from that pile. If the pile
     * has less than k bananas, she eats all of them instead and will not eat any
     * more bananas during this hour.
     * 
     * Koko likes to eat slowly but still wants to finish eating all the bananas
     * before the guards return.
     * 
     * Return the minimum integer k such that she can eat all the bananas within h
     * hours.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     * Example 2:
     * 
     * Input: piles = [30,11,23,4,20], h = 5
     * Output: 30
     * Example 3:
     * 
     * Input: piles = [30,11,23,4,20], h = 6
     * Output: 23
     * 
     * 
     * Constraints:
     * 
     * 1 <= piles.length <= 104
     * piles.length <= h <= 109
     * 1 <= piles[i] <= 109
     */

    // Method to solve the Problem
    boolean canEat(int cnt, int hour, int[] piles) {

        int hoursElapsed = 0;

        for (int val : piles) {
            hoursElapsed += (val / cnt);
            if (val % cnt != 0)
                hoursElapsed++;
            if (hoursElapsed > hour)
                return false;
        }
        return hoursElapsed <= hour;
    }

    public int minEatingSpeed(int[] piles, int h) {

        /*
         * APPROACH
         * if a person can eat all piles in h hours with x banana in 1 hour then,
         * he can eat all bananas if he eats more than 'x' bananas in one hour
         */

        int low = 1, high = piles[0];
        for (int val : piles) {
            high = Math.max(high, val);
        }

        int minBananas = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canEat(mid, h, piles)) {
                minBananas = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minBananas;
    }
    // Time Complexity: O(n * log(max(piles)))
    // Space Complexity: constant
}
