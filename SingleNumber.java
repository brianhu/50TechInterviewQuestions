package brian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by brian on 11/3/17.
 */
public class SingleNumber {
    public int singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int count = map.containsKey(x) ? map.get(x) : 0;
            map.put(x, count + 1);
        }
        for (int x : nums) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No single element");
    }

    public int singleNumberBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int x : nums) {
            num ^= x;
        }
        return num;
    }
}
