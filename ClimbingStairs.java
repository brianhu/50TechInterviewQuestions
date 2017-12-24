package brian;

/**
 * Created by brian on 12/16/17.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int n_2 = 1;
        int n_1 = 2;
        int answer = 0;
        for (int i = 3; i <= n; i++) {
            answer = n_2 + n_1;
            n_2 = n_1;
            n_1 = answer;
        }
        return answer;
    }
}
