package brian;

/**
 * Created by brian on 12/24/17.
 */
public class CoinsInALine {
    public boolean firstWillWin(int n) {
        boolean[] dp = new boolean[n + 1];
        if (n >= 0) dp[0] = false;
        if (n >= 1) dp[1] = true;
        if (n >= 2) dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 2];
        }
        return dp[n];
    }

    public boolean firstWillWinByMath(int n) {
        return (n % 3) != 0;
    }
}
