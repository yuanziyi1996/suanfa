package LeeCode.字符串和数组;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

 示例 1:

 输入: [3, 1, 4, 1, 5], k = 2
 输出: 2
 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 尽管数组中有两个1，但我们只应返回不同的数对的数量。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组中的K_diff数对 {
    public static int findPairs(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }

        if(k<0) return  0;
        HashSet setMem = new HashSet<Integer>();
        HashSet Diff = new HashSet<Integer>();
        int ans=0;
        for (int i=0;i<nums.length;i++){
            if(setMem.contains(nums[i]+k)) {
                Diff.add(nums[i]);
            }
            if(setMem.contains(nums[i]-k)) {
                // 特别注意这里是添加 nums[i]-k而不是 nums[i]
                Diff.add(nums[i]-k);
            }
            setMem.add(nums[i]);
        }
        return Diff.size();
    }

    public static void main(String[] args) {
        int a [] ={3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(a,k));
    }
}

