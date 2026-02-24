import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static ArrayList<Integer> findLeaders(int nums[]) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int len = nums.length;

        if (len <= 1) {
            return leaders;
        }

        int maxi = -1;// all values in nums are positive

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] >= maxi) {
                leaders.add(nums[i]);
                maxi = nums[i];
            }
        }

        Collections.reverse(leaders);

        return leaders;
    }
}
