package LeeCode.字符串和数组;

/**
 * @author ziyi.yuan
 * @date 2020/8/6 10:09 上午
 * @link url:https://leetcode-cn.com/problems/maximum-product-subarray/
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 */
public class 乘积最大子数组 {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = 1;
        int max = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,4,-3,5,-4,6};
        System.out.println(maxProduct(nums));
    }
}
