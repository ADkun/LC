package solutions.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, n, "", result);
        return result;
    }

    private void solve(int left, int right, String sublist, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sublist);
        }
        if (left > 0) {
            solve(left - 1, right, sublist + "(", result);
        }
        if (right > left) {
            solve(left, right - 1, sublist + ")", result);
        }
    }
}
