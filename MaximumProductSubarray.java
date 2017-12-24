package brian;

/**
 * Created by brian on 12/24/17.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max, tempMin = min;
            max = Math.max(Math.max(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            min = Math.min(Math.min(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            answer = Math.max(max, answer);
        }
        return answer;
    }
}
