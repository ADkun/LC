package solutions.array;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        IsValidSudoku obj =  new IsValidSudoku();
        obj.solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
    }

    private Set<Character>[] rows = new HashSet[9];
    private Set<Character>[] cols = new HashSet[9];
    private Set<Character>[] boxes = new HashSet[9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // 先扫描一遍
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    int boxesInd = i / 3 * 3 + j / 3;
                    boxes[boxesInd].add(board[i][j]);
                }
            }
        }

        solve(0, 0, board);
    }

    private boolean solve(int i, int j, char[][] board) {
        if (j == 9) {
            j = 0;
            ++i;
        }
        if (i == 9)
            return true;

        if (board[i][j] == '.') {
            // 如果该位置是空
            for (char k = '1'; k <= '9'; ++k) {
                if (isValid(i, j, k, board)) {
                    board[i][j] = k;
                    if (solve(i, j + 1, board))
                        return true;
                    else {// 回滚
                        board[i][j] = '.';
                        rows[i].remove(k);
                        cols[j].remove(k);
                        boxes[i / 3 * 3 + j / 3].remove(k);
                    }
                }
            }
            return false;
        } else if (solve(i, j + 1, board)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid(int i, int j, char k, char[][] board) {
        if (rows[i].contains(k)) {
            return false;
        }

        if (cols[j].contains(k)) {
            return false;
        }
        // 计算第几个盒子
        int boxInd = (i / 3) * 3 + j / 3;
        if (boxes[boxInd].contains(k)) {
            return false;
        }

        rows[i].add(k);
        cols[j].add(k);
        boxes[boxInd].add(k);
        return true;
    }
}
