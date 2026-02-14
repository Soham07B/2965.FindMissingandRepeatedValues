class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = 1L * n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSqSum = N * (N + 1) * (2 * N + 1) / 6;

        long s = 0, sq = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long x = grid[i][j];
                s += x;
                sq += x * x;
            }
        }

        long d1 = s - expectedSum;        // a - b
        long d2 = sq - expectedSqSum;     // a^2 - b^2

        long sumAB = d2 / d1;             // a + b

        long a = (d1 + sumAB) / 2;
        long b = a - d1;

        return new int[]{(int)a, (int)b};
    }
}
