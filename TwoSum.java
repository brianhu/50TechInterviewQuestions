package brian;

import java.util.HashMap;

/**
 * Created by brian on 8/13/17.
 */
public class TwoSum {
    public int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // [2, 7, 4, 3]
        // {
        //    2: 0,
        //    7: 1,
        //    4: 2,
        //    3: 3
        // }
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[] { map.get(target - x), i };
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("no solution!!!");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution!!!");
    }
}
