package LeeCode.字符串和数组;

import java.util.Arrays;

public class 八八合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1 -= 1;
            } else {
                nums1[p] = nums2[p2];
                p2 -= 1;
            }
            p -= 1;
        }

        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        System.out.println(Arrays.toString(nums1));

    }


    public static void main(String[] args) {
        int nums1[] = {0};
        int nums2[] = {1};
        int m = 3;
        int n = 3;
        merge(nums1, 0, nums2, 1);
    }
}
