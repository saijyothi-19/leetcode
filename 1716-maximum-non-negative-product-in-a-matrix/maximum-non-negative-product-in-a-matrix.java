class Solution {
    public int maxProductPath(int[][] grid) {
 /*
        #########################################################################
        #                                                                       #
        #  =============================================                      #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                      #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                     #
        #  Description : Solution / Code / Project                                #
        #  Date        : 2026-03-23                                             #
        #                                                                       #
        #########################################################################
        */
        int m = grid.length;
        int n = grid[0].length;
        long mod = (long) 1e9 + 7;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) { // SET COLUMN 1 OF BOTH DP MATRICES
            max[i][0] = grid[i][0] * max[i - 1][0];
            min[i][0] = max[i][0];
        }
        for (int i = 1; i < n; i++) { // SET ROW 1 OF BOTH DP MATRICES
            max[0][i] = grid[0][i] * max[0][i - 1];
            min[0][i] = max[0][i];
        }
        for (int i = 1; i < m; i++) // UPDATING DP MARIXES
            for (int j = 1; j < n; j++) {
                long k = grid[i][j];
                long a = max[i][j - 1];
                long b = max[i - 1][j];
                long c = min[i][j - 1];
                long d = min[i - 1][j];
                max[i][j] = Math.max(Math.max(k * a, k * b), Math.max(k * c, k* d));
                min[i][j] = Math.min(Math.min(k * a, k * b), Math.min(k * c, k* d));
            }
        if (max[m - 1][n - 1] > -1) // CHECKING IF PRODUCT IS POSITIVE
            return (int) (max[m - 1][n - 1] % mod);
        return -1;
    }
}