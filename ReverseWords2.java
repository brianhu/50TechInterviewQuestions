package brian;

/**
 * Created by brian on 8/27/17.
 */
public class ReverseWords2 {
    public void reverseWords(char[] s) {
        // "the sky is blue"
        reverse(s, 0, s.length - 1);
        // "eulb si yks eht"
        int i = 0;
        for (int j = 0; j <= s.length; j++) {
            if (s[j] == ' ' || j == s.length) {
                // "eulb "
                reverse(s, i, j - 1);
                // "blue"
                i = j + 1;
            }
        }
        // "blue is sky the"
    }

    private void reverse(char[] s, int begin, int end) {
        // "the sky is blue"
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            // temp = t
            s[begin + i] = s[end - i];
            // s[end - i] = e => s[begin + i] = e
            s[end - i] = temp;
            // s[end - i] = t
        }
    }
}
