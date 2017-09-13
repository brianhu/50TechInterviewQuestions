package brian;

/**
 * Created by brian on 8/8/17.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // [2, 7, 1, 8]
        // [3, 9, 9]
        // [9, 9] -> [1, 0, 0]
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] = digit + 1;
                return digits;
            } else { // digit == 9
                digits[i] = 0;
            }
        }
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }
}
