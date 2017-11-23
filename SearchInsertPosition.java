package brian;

/**
 * Created by brian on 10/20/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (nums[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (nums[L] < target) ? L + 1 : L;
    }
}
