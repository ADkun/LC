package solutions.array;

import java.util.*;

public class Solution {


//    public void voidMethod(Object a){
//        a.length();
//    }

    /**
     * javadoc注释
     * 生成一个指定格式的字符串
     *
     * @param n 迭代次数
     * @return 返回生成的目标字符串
     * @author adkun 作者
     * @since 3
     */
    public String countAndSay2(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);
        StringBuilder s;
        for (int i = 1; i < n; i++) {
            // 循环n-1次（因为第一次一定是1）
            s = new StringBuilder();
            int start = 0; // 记录每次的新数字
            for (int j = 1; j < result.length(); j++) {
                // 遍历result（第一次是[1]，第二次是[11],第三次是[21]，第四次是[1211]，第五次是[111221]
                if (result.charAt(start) != result.charAt(j)) {
                    //如果碰到不一样的数字，就将新的统计的数字放到s
                    s.append(j - start).append(result.charAt(start));
                    // 第四次，j=1,start=0, 即加入[1-0,2]
                    start = j;
                }
            }
            //第四次，length=2,start=1,2-1=1,再加1
            s.append(result.length() - start).append(result.charAt(start));
            result = s;
        }
        return result.toString();
    }

    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);
        for (int i = 1; i < n; i++) {
            // 记录当前行的字符串
            StringBuilder s = new StringBuilder();
            // 记录每个数字的开始索引
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                // 当数字发生改变时执行
                if (result.charAt(j) != result.charAt(start)) {
                    s.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            // 字符串最后一个数字
            s.append(result.length() - start).append(result.charAt(start));
            result = s;
        }
        return result.toString();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        // 《两个数组交集2》法2：排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0, index2 = 0;
        int[] result = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        int len = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result[len++] = nums1[index1];
                ++index1;
                ++index2;
            } else if (nums1[index1] < nums2[index2]) {
                ++index1;
            } else {
                ++index2;
            }
        }
        return Arrays.copyOfRange(result, 0, len);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // 《两个数组交集2》 法1：哈希映射
        // 对第一个数组建立哈希表，记录每个数字出现的次数
        // 遍历第二个数组，如果该数字出现在哈希表，则添加到答案并将该数字次数-1
        Map<Integer, Integer> map = new HashMap<>();
        //先遍历较短的
        int[] shotNums;
        int[] longNums;
        if (nums1.length < nums2.length) {
            shotNums = nums1;
            longNums = nums2;
        } else {
            shotNums = nums2;
            longNums = nums1;
        }

        for (int i : shotNums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(20);
        for (int i : longNums) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }

    public int singleNumber4(int[] nums) {
        // 《只出现一次的数字》 异或法
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }

    public int singleNumber3(int[] nums) {
        // 《只出现一次的数字》 集合数减法
        Set<Integer> set = new HashSet<>();
        int setCount = 0, numCount = 0;
        for (int i = 0; i < nums.length; i++) {
            numCount += nums[i];
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                setCount += nums[i];
            }
        }
        // 数组之和 - 集合之和，就是单独的数字
        return setCount * 2 - numCount;
    }

    public int singleNumber2(int[] nums) {
        // 《只出现一次的数字》 哈希表法
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 遍历哈希表
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result = key;
            }
        }
        return result;
    }

    public int singleNumber1(int[] nums) {
        // 《只出现一次的数字》 集合法
        // 遍历数组，每次集合没有就加入，集合有就删除，最后剩下的就是不重复数
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> itr = set.iterator();
        return (int) itr.next();
    }

    public int singleNumber(int[] nums) {
        // 《只出现一次的数字》
        if (nums.length == 1) return nums[0];

        boolean ok = false;
        Arrays.sort(nums);
        int result = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                result = nums[i];
                ok = true;
                break;
            }
        }
        if (ok) {
            return result;
        } else {
            if (nums[0] != nums[1])
                result = nums[0];
            else if (nums[nums.length - 1] != nums[nums.length - 2])
                result = nums[nums.length - 1];
        }
        return result;
    }

    public boolean containsDuplicate(int[] nums) {
        // 《存在重复元素》，哈希表
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (st.contains(nums[i])) {
                return true;
            } else {
                st.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        // 《存在重复元素》，排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public static int gcd(int x, int y) {
        // 最大公约数
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void reverse(int[] nums, int start, int end) {
        // 数组转置，双指针
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        //旋转数组，法3,两次旋转，O(2n)时间复杂度,O(1)空间复杂度
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void rotate1(int[] nums, int k) {
        // 旋转数组法2，环状替换,O(1)空间复杂度;
        if (nums.length == 0) return;

        int len = nums.length;
        k = k % len;
        int loopTimes = gcd(len, k);

        for (int round = 0; round < loopTimes; round++) {
            int current = round;
            int num = nums[current];
            do {
                int newPos = (current + k) % len;
                int newNum = nums[newPos];
                nums[newPos] = num;
                current = newPos;
                num = newNum;
            } while (current != round);
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        //旋转数组，O(n)空间复杂度
        int len = nums.length;
        int temp, pos;
        k = k % len;//旋转次数取余，避免循环
        String orientation = "right";
        int[] result = new int[len];
        if (k > len / 2) {
            //如果向右旋转大于数组长度的一半，那么就向左转len-k次
            k = len - k;
            orientation = "left";
        }
        switch (orientation) {
            case "right":
                for (int i = 0; i < len; i++) {
                    int newPos = (i + k) % len;
                    result[newPos] = nums[i];
                }
                break;

            case "left":
                for (int i = 0; i < len; i++) {
                    int newPos = i - k < 0 ? len + (i - k) : i - k;
                    result[newPos] = nums[i];
                }
                break;
        }
        System.arraycopy(result, 0, nums, 0, len);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 1;
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public int maxProfit(int[] prices) {
        // 股票收益，贪心算法
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        //股票收益，动态规划
        if (prices.length == 0)
            return 0;

        // 由于后一天的和前一天以前的状态无关，所以不需要使用数组存储
        // 优化的动态规划
        int dp0 = 0, dp1 = -prices[0];
        int newDp0, newDp1;
        for (int i = 1; i < prices.length; i++) {
            newDp0 = Math.max(dp0, dp1 + prices[i]);
            newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
