package brian;

/**
 * Created by brian on 8/15/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (j > i) {
            //"i am smart, am not i?"
            while (j > i && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j))
                    ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
