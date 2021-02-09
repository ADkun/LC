package solutions.array;

public class Fib {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] ans = new int[3];

        ans[0] = 0;
        ans[1] = 1;

        for (int i = 2; i <= n; ++i) {
            ans[2] = (ans[0] + ans[1]) % 1000000007;
            ans[0] = ans[1];
            ans[1] = ans[2];
        }

        return (int) ans[2];
    }
}
