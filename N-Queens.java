import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(result, board, 0, n);
        return result;
    }
    private void solve(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] chars : board) solution.add(new String(chars));
            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
}
