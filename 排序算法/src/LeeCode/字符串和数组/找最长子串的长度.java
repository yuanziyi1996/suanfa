package LeeCode.字符串和数组;

import java.util.HashSet;
import java.util.Set;

public class 找最长子串的长度 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        int end = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
//                ans = Math.max(ans, j - i);
                if(ans<j-i){
                    ans = j-i;
                    end = j-1;
                }
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println("结束下标为："+end);
        System.out.println("最长字符串是："+s.substring(end-ans+1,end+1));
        return ans;
    }

    public static void main(String[] args) {
        String str = "sdfswgosdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
