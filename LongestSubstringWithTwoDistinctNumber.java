package brian;

/**
 * Created by brian on 8/25/17.
 */
public class LongestSubstringWithTwoDistinctNumber {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] characterCounter = new int[256];
        int i = 0, distinctNumber = 0, maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if (characterCounter[s.charAt(j)] == 0) {
                distinctNumber++;
            }
            characterCounter[s.charAt(j)]++;
            while (distinctNumber > 2) {
                characterCounter[s.charAt(i)]--;
                if (characterCounter[s.charAt(i)] == 0) {
                    distinctNumber--;
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
