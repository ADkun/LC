package solutions.array;

import java.lang.reflect.Array;
import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        NQueens n = new NQueens();
        n.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        solver(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new String[n], result);
        return result;
    }

    private void solver(int n, int level, Set<Integer> cols, Set<Integer> pie, Set<Integer> na,
                        String[] board, List<List<String>> res) {
        if (level == n) {
            List<String> list = new ArrayList<>(n);
            for (String s : board) {
                list.add(s);
            }
            res.add(list);
        } else {
            for (int c = 0; c < n; ++c) {
                if (!cols.contains(c) && !pie.contains(c + level) && !na.contains(c - level)) {
                    // 说明该点可以落子
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';

                    board[level] = new String(row);

                    cols.add(c);
                    pie.add(c + level);
                    na.add(c - level);

                    solver(n, level + 1, cols, pie, na, board, res);

                    cols.remove(c);
                    pie.remove(c + level);
                    na.remove(c - level);
                }
            }
        }
    }


}
