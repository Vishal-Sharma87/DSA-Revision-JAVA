package binarysearch;

public class FindIndexOfTarget {

    /*
     * returns first or last occurrence of target in a sorted array using binary
     * search
     */

    /**
     * 
     * @param nums   Integer array in which searching is executed
     * @param s      Starting index of range in integer array
     * @param e      Ending index of range in integer array
     * @param target Value to search in integer array
     * @param first  If true then finds first occurence of target, else finds last
     *               occurrenec of target
     * @return return valid index based on first or last occurrence, returns -1 if
     *         target is not found
     */
    public int find(int[] nums, int s, int e, int target, boolean first) {
        int idx = -1;
        if (s > e)
            return idx;

        int mid;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (first) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return idx;
    }

}
