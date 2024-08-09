package LeetCode.Leet_ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // 여기서 currentSum - target을 해도 절댓값을 비교하기 때문에 결국 둘 사이의 차이를 비교한다는 의미는 같다.
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum > target) {
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
