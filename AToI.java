package brian;

/**
 * Created by brian on 8/17/17.
 */
public class AToI {
    public int atoi(String str) {
        /*
            string 不是數字 => return 0
            string 有數字也有非數字 => 非數字只出現在數字後
            Overflow => return Integer.MAX_VALUE / Integer.MIN_VALUE
            頭尾空白字元 => 有
            正負號 => 有
         */
        int i = 0, n = str.length(), sign = 1;
//        while (i < n && str.charAt(i) == ' ') i++;
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && str.charAt(i) == '+') {
            i++;
        }
        int answer = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int x = Character.getNumericValue(str.charAt(i));
            if (answer > Integer.MAX_VALUE / 10 ||
                    (answer == Integer.MAX_VALUE / 10 && x >= 8)) {
//                if (sign == -1) {
//                    return Integer.MIN_VALUE;
//                } else {
//                    return Integer.MAX_VALUE;
//                }
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            answer = answer*10 + x;
            i++;
        }
        return sign * answer;
    }
}
