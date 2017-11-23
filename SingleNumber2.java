package brian;

/**
 * Created by brian on 11/18/17.
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public int genericSingleNumber(int[] nums) { // 較冗長，但適用性較廣
        int ans = 0;
        for(int i = 0; i < 32; i++) { // 假設是 32-bit integer
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) { // 檢查每個數字的每個 bit 是否為 1
                    sum++;
                    sum %= 3; //若 bit 出現 3 次則將其消除。可將 3 改為任意數字 n
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }
}
