import java.util.Arrays;

class Solution {
    int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                if (sum < target) left++;
                else right--;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int[] nums2 = {0, 0, 0};
        System.out.println(new Solution().threeSumClosest(nums1, 1));
        System.out.println(new Solution().threeSumClosest(nums2, 1));
    }
}
