package brian;

import java.util.Arrays;

/**
 * Created by brian on 8/21/17.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] characterMap = new int[256];
        Arrays.fill(characterMap, -1);
//        for (int i = 0; i < characterMap.length; i++) {
//            characterMap[i] = -1;
//        }
        int start = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // s = "abcabc"
            // start = 1
            if (characterMap[s.charAt(i)] >= start) {
                start = characterMap[s.charAt(i)] + 1;
            }
            characterMap[s.charAt(i)] = i; // characterMap[97]
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
