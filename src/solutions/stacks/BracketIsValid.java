package solutions.stacks;

import java.util.*;

public class BracketIsValid {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); ++i) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !isPaired(stack.peek(), s.charAt(i)))
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    private boolean isLeft(char c) {
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    private boolean isPaired(char ca, char cb) {
        if (ca == '(' && cb == ')')
            return true;
        if (ca == '[' && cb == ']')
            return true;
        if (ca == '{' && cb == '}')
            return true;
        return false;
    }
}
