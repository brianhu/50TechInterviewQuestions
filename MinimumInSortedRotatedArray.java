package brian;

/**
 * Created by brian on 10/21/17.
 */
public class MinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (nums[M] > nums[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return nums[L];
    }
}
