package brian;

import java.util.HashMap;
public class Main {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[] { map.get(target - x), i };
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("no solution");
    }
}
