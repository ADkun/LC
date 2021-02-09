package solutions.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracketIsValidII {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>(len);
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < len; ++i) {
            char ca = s.charAt(i);
            if (!map.containsKey(ca)) {
                stack.push(ca);
            } else if (stack.isEmpty() || !stack.pop().equals(map.get(ca))) {
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char ca = s.charAt(i);
            if (!stack.isEmpty()) {
                char t = stack.peek();
                if (t == '(' && ca == ')'
                        || t == '[' && ca == ']'
                        || t == '{' && ca == '}'
                ) {
                    stack.pop();
                    continue; // 这步可以省去判断
                }
            }
            stack.push(s.charAt(i)); //空的话就加入
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        int len;
        do {
            len = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (!(len == s.length()));
        return s.length() == 0;
    }
}
