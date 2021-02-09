package solutions.array;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return null;

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i <= nums.length - k; ++i) {
            // 循环n-k次，每次循环k个内部值找出最大值
            int max = nums[i];
            for (int j = i + 1; j < i + k; ++j) {
                max = nums[j] > max ? nums[j] : max;
            }
            result[index++] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; ++i) {
            if (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; ++i) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
