package brian;

/**
 * Created by brian on 7/23/17.
 */
public class ReverseInteger {
    public static int reverseByString(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        String inputString = Integer.toString(x);
        String s = new StringBuilder(inputString).reverse().toString();
        int answer;
        try {
            answer = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (negative) {
            answer *= -1;
        }
        return answer;
    }

    public static int reverseByModulo(int x) {
        int answer = 0;
        while (x != 0) {
            // -2147483648~2147483647
            if (answer > 214748364 || answer < -214748364 ||
                    (answer == 214748364 && x % 10 > 7) ||
                    (answer == -214748364 && x % 10 < -8)
                    ) {
                return 0;
            }
            // 123
            answer = answer * 10 + x % 10;
            // 0 + 3 => 3
            // 30 + 2 => 32
            // 320 + 1 => 321
            x /= 10;
            // 12
            // 1
            // 0
        }
        return answer;
    }
}








