package LeeCode.字符串和数组;

/**
 * 数组相邻的不能相加，找出其中最大值
 * f(k) = 从前 k 个房屋中能抢劫到的最大数额，A_i= 第 i 个房屋的钱数。
 f(k) = max(f(k – 2) + A_k, f(k – 1))
 */
public class 一九八打家劫舍 {
    public static int rob(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(length ==1){
            return nums[0];
        }

        if(length == 2){

            return   Math.max(nums[0],nums[1]);
        }
        int currMax=0;
        int prevMax = 0;
        if(length >2){
            for (int i = 0; i <length ; i++) {
                int temp = currMax;
                currMax = Math.max(prevMax + nums[i], currMax);
                prevMax = temp;
            }

        }
        return currMax;
    }

    public static void main(String[] args) {
        int a [] = {2,7,9,3,1};
        System.out.println(rob(a));
    }
}
