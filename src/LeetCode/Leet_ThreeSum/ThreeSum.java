package LeetCode.Leet_ThreeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int fixed = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (fixed + nums[left] + nums[right] == 0) {
                    resultSet.add(List.of(fixed, nums[left++], nums[right--]));
                } else if (fixed + nums[left] + nums[right] > 0) {
                    right--;
                } else if (fixed + nums[left] + nums[right] < 0) {
                    left++;
                }
            }
        }

        List<List<Integer>> output = new ArrayList<>(resultSet);
        return output;
    }
}
