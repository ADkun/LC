package solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensNum {

    public int totalNQueens(int n) {
        List<Byte> result = new ArrayList<>();
        count(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], result);
        return result.size();
    }

    private void count(int n, int level, boolean[] cols, boolean[] pie, boolean[] na, String[] board,
                      List<Byte> result) {
        if (level == n) {
            result.add((byte) 0);
        } else {
            for (int col = 0; col < n; ++col) {
                int nowPie = col + level;
                int nowNa = col - level + n;
                if (!cols[col] && !pie[nowPie] && !na[nowNa]) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[col] = 'Q';

                    cols[col] = true;
                    pie[nowPie] = true;
                    na[nowNa] = true;

                    count(n, level + 1, cols, pie, na, board, result);

                    cols[col] = false;
                    pie[nowPie] = false;
                    na[nowNa] = false;
                }
            }
        }
    }
}
