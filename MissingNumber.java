package brian;

/**
 * Created by brian on 11/22/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result ^ i;
    }
}
