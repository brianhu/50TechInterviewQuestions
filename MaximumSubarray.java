package brian;

/**
 * Created by brian on 12/24/17.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int answer = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            answer = Math.max(maxEndingHere, answer);
        }
        return answer;
    }
}
