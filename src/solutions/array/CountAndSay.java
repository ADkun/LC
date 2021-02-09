package solutions.array;

public class CountAndSay {

    /**
     * 生成外观数列
     * 递归法
     *
     * @param n：第n次循环生成的外观数列
     * @return 本次循环生成的外观数列
     */

    public String countAndSay(int n) {
        // 递归结束
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(start) != s.charAt(i)) {
                sb.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        sb.append(s.length() - start).append(s.charAt(start));
        return sb.toString();
    }
}
