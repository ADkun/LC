package solutions.other;

public class NPosNeg {

    public static void nPosNeg(int n) {
        if (n < 1) return;

        int pos = 0, neg = 0;
        if (n % 2 == 0) {
            pos = (1 + (n - 1)) * n / 4;
            neg = -((2 + n) * n / 4);
        } else {
            pos = (1 + n) * n / 4 + (n / 2 + 1);
            neg = -((2 + n - 1) * n / 4);
        }
        System.out.println(pos + neg);
    }

    public static int nPosNeg2(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        return n % 2 == 0 ? -(n / 2) : n / 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(nPosNeg2(7));
    }
}
