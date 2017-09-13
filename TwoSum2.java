package brian;

/**
 * Created by brian on 8/15/17.
 */
public class TwoSum2 {
    public int[] twoSum2ByPointers(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (j > i) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] { i, j };
            }
        }
        throw new IllegalArgumentException("no solution!!");
    }

    public int[] twoSum2ByBinarySearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int j = binarySearch(nums, target - x);
            if (j != -1) {
                return new int[] { i, j };
            }
        }
        throw new IllegalArgumentException("no solution!!");
    }

    private int binarySearch(int[] intArray, int key) {
        int low = 0;
        int high = intArray.length - 1;
        while (high >= low) {
            int middle = (low + high) / 2;
            if (intArray[middle] == key) {
                return middle;
            }
            if (intArray[middle] < key) {
                low = middle + 1;
            }
            if (intArray[middle] > key) {
                high = middle - 1;
            }
        }
        return -1;
    }
}
