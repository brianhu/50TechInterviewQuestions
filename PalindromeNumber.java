package brian;

/**
 * Created by brian on 8/13/17.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // -12321 => -12321-
        }
        int divisor = 1;
        // 12321 / 10000 = 1
        while (x / divisor >= 10) {
            divisor *= 10;
        }
        while (x != 0) {
            int leftDigit = x / divisor;
            int rightDigit = x % 10;
            if (leftDigit != rightDigit) {
                return false;
            }
            x = (x % divisor) / 10;
            // x = 12321 divisor = 10000
            // (x % divisor) = 2321
            // 2321 / 10 = 232
            divisor /= 100;
        }
        return true;
    }
}
