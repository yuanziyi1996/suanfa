package LeeCode.字符串和数组;

import java.util.Arrays;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 */
public class 验证回文串 {
    public static boolean huiwen(String s) {
        char a[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (('0' <= a[i] && a[i] <= '9') || 'a' <= a[i] && a[i] <= 'z') {
                a[count++]=a[i];
            } else if (('A' <= a[i] && a[i] <= 'Z')) {
                a[count++]= (char) (a[i] - 'A' + 'a');
            }
        }
        System.out.println(Arrays.toString(a));
        int l = 0;
        int r = count-1;
        while (l < r) {
            if(a[l]==a[r]){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(huiwen(s));
    }
}
