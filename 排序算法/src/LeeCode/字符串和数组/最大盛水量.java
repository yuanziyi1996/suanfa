package LeeCode.字符串和数组;

import java.util.Arrays;

public class 最大盛水量 {
    public static int maxArea(int[] height) {
        int length = height.length;
        int result = 0;
        int max = 0;
        int tem[] = new int[length];
        for(int i = 0;i<length;i++) {
            for (int j = i + 1; j < length ; j++) {
                max = Math.min(height[j], height[i]);
                result = Math.max(result, max * (j - i));
            }
        }
        System.out.println(Arrays.toString(tem));
        return result;
    }

    /**
     * 双指针发
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }



    public static void main(String[] args) {
        int a[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }

}
