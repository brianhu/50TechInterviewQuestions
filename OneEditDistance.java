package brian;

/**
 * Created by brian on 8/29/17.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n - m > 1) return false;
        int i = 0, shift = n - m; // shift = 0 or 1
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        // s = "abc"     "abc"      "abbde"   "adc"
        // t = "abc"     "abcd"     "abcde"   "abdc"
        //         i         i         i        i
        //         i == m         s.charAt(i) != t.charAt(i)
        if (i == m) return shift > 0;
        if (shift == 0) i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == m;
    }
}
