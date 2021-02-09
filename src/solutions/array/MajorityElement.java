package solutions.array;

import java.util.Arrays;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int maxCount = 0;
        int cur = nums[0];
        int i = 0;
        while (i < nums.length && nums[i] == nums[0]) {
            ++maxCount;
            ++i;
        }
        while (i < nums.length) {
            if (nums[i] != cur) {
                int k = i;
                int count = 0;
                while (k < nums.length && nums[k] == nums[i]) {
                    ++count;
                    ++k;
                }
                if (maxCount < count) {
                    cur = nums[k - 1];
                    i = k - 1;
                    maxCount = count;
                }
            }
            ++i;
        }
        return cur;
    }

    public static int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement2(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == nums[i + 1]) {
                int k = i;
                int count = 0;
                while (k < nums.length && nums[k] == nums[i]) {
                    ++count;
                    ++k;
                }
                if (count > nums.length / 2)
                    return nums[i];
                i = k - 1;
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 6, 7, 7};
        majorityElement(arr);
    }
}
