package brian;

/**
 * Created by brian on 12/23/17.
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m][n - 1] = 1;
        for (int c = n - 1; c >= 0; c--) {
            for (int r = m - 1; r >= 0; r--) {
                matrix[r][c] = (obstacleGrid[r][c] == 1) ? 0 : matrix[r + 1][c] + matrix[r][c + 1];
            }
        }
        return matrix[0][0];
    }
}
