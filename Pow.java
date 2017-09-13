package brian;

/**
 * Created by brian on 8/10/17.
 */
public class Pow {
    public double optimizedPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }
        if (n % 2 == 0) {
            // pow(2, 4) = 2^4 = 2 * 2 * 2 * 2 = 2^2 * 2^2 = 4 * 4 = 4^2 = pow(4, 2)
            return optimizedPow(x * x, n / 2);
        } else {
            // pow(2, 3) = 2^3 = 2 * 2 * 2 = 2^1 * 4^1 = 2 * pow(4, 1)
            return x * optimizedPow(x * x, n / 2);
        }
    }

    public double pow(double x, int n) {
        double answer = 1;
        boolean negative = false;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            negative = true;
            n *= -1;
        }
        for (int i = 0; i < n; i++) {
            answer *= x;
        }
        if (negative) {
            answer = 1 / answer;
        }
        return answer;
    }
}
