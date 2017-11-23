package brian;

/**
 * Created by brian on 11/19/17.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n > 0 && (n & (n - 1)) == 0) return true;
        return false;
    }
}
