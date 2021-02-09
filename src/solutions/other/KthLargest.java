package solutions.other;

import java.util.*;

public class KthLargest {

    private int k;
    private Queue<Integer> pQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pQueue.size() < k) {
            pQueue.offer(val);
        } else if (pQueue.peek() < val) {
            pQueue.poll();
            pQueue.offer(val);
        }
        return pQueue.peek();
    }
}
