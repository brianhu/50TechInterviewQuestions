package brian;

/**
 * Created by brian on 12/20/17.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m][n - 1] = 1;
        for (int c = n - 1; c >= 0; c--) {
            for (int r = m - 1; r >= 0; r--) {
                matrix[r][c] = matrix[r + 1][c] + matrix[r][c + 1];
            }
        }
        return matrix[0][0];
    }

    public int uniquePathsByMath(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--; n--;
        long answer = 1;
        for (int i = m + 1, j = 1; i <= m + n; i++, j++) {
            answer *= i;
            answer /= j;
        }

        return (int)answer;
    }
}
