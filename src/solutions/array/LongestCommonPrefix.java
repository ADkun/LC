package solutions.array;

public class LongestCommonPrefix {

    /**
     * 最长公共前缀
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();

        int index = 0;
        int minLen = 201;
        for (String str : strs) {
            minLen = str.length() < minLen ? str.length() : minLen;
        }

        int strsLen = strs.length;
        label1:
        for (int i = 0; i < minLen; ++i) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != ch) {
                    break label1;
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
