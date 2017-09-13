package brian;

/**
 * Created by brian on 7/11/17.
 */
public class ReverseWords {
    public String reverseWordsByPointers(String s) {
        StringBuilder answer = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            // s = "  the sky is    blue  "
            //               i
            //               j
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                answer.append(s.substring(i, j) + " ");
            }
        }
        return answer.toString().trim();
    }

    public String reverseWordsByArray(String s) {
        String[] splitedWords = s.split("\\s+");
        // splitedWords = ["the", "sky", "is", "blue"]
        String answer = "";
        for (int i = splitedWords.length - 1; i >= 0; i--) {
            answer += splitedWords[i] + " ";
        }
        // answer = "blue is sky the"
        return answer.trim();
    }
}
