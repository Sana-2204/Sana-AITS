class Solution {
    public int totalNQueens(int n) {
        return solve(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
    }
    private int solve(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) return 1;
        int count = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n, d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            cols[col] = diag1[d1] = diag2[d2] = true;
            count += solve(row + 1, cols, diag1, diag2, n);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
        return count;
    }
}
