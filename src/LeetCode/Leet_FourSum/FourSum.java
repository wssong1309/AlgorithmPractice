package LeetCode.Leet_FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> quadruplet = new ArrayList<>();
        Arrays.sort(nums);

        // 중복을 제거할 때 Set이 아니라 직접 조건을 적용해서 제거했다.
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long pointerTarget = (long) target - nums[i] - nums[j];
                    long duplet = (long) nums[left] + nums[right];
                    if (pointerTarget == duplet) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (pointerTarget > duplet) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
