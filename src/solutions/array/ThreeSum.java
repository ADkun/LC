package solutions.array;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; ++first) {
            if (nums[first] > 0) break; // 第一个数大于0，后面肯定都大于0
            if (first > 0 && nums[first] == nums[first - 1]) // a去重
                continue;
            int second = first + 1; // 初始化b、c指针
            int third = nums.length - 1;
            while (second < third) {
                // 左右指针
                int sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) // 左指针右移
                    --third;
                else if (sum < 0) // 右指针左移
                    ++second;
                else { // 符合a+b+c=0
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                    // 去重
                    while (second < third && nums[second] == nums[second + 1])
                        ++second;
                    while (second < third && nums[third] == nums[third - 1])
                        --third;
                    ++second;
                    --third;
                }
            }
        }
        return result;
    }
}
