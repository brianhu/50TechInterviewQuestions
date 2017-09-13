package brian;

/**
 * Created by brian on 8/16/17.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                // i = haystack 目前的 index
                // j = needle 目前的 index，同時也是從 i 開始往後數第 n 個數字
                // haystack = "i am smart", needle = "am"
                //               i
                //                 j
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
        throw new IllegalArgumentException("no solution!");
    }
}
