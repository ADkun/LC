package solutions;

public class MyPow {
    public static double myPow3(double x, int n) {
        // 特殊条件
        if (n == 0 || x == 1.0) return 1.0;
        if (n == 1 || x == 0.0) return x;
        long N = (long) n;

        // n为负数
        if (n < 0) {
            x = 1.0 / x;
            N = -N;
        }

        /**
         * 遍历n的每一位
         * 例：n=2, 二进制10，第一次遍历n&1==0不算，第二次遍历n&1==1，这时x=x^2，即pow = x^n
         * 例2：n=5，二进制101，结果为pow = x^1 * x^4 = x^n
         */
        double pow = 1.0;
        while (N != 0) {
            if ((N & 1) != 0) {
                pow *= x;
            }
            x *= x;
            N >>= 1;
        }
        return pow;
    }

    private static double helper(double x, long n) {
        if (n == 1) return x;
        else if (n == 0) return 1;

        if (x == 1.0) return 1.0;
        else if (x == 0.0) return 0.0;

        if (n < 0) return 1.0 / helper(x, -n);

        if (n % 2 == 0) {
            // 偶数
            return helper(x * x, n / 2);
        } else {
            //奇数
            return helper(x, n - 1) * x;
        }
    }

    public static double myPow(double x, int n) {
        long N = (long) n;
        return helper(x, n);
    }

    public static double myPow2(double x, int n) {
        if (x == 1.0) return x;
        double ori = x;
        if (n > 0) {
            for (int i = 1; i < n; ++i)
                x *= ori;
            return x;
        } else if (n < 0) {
            for (int i = 0; i > n; --i)
                x = 1.0 / myPow2(ori, -n);
            return x;
        } else {
            return 1.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(2 >> 1);
    }
}
