package LeeCode.字符串和数组;

import java.util.*;

public class 罗马数字转整数 {
    public static int romanToInt(String s) {
        int[] moneys = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String string = "MI";
        System.out.println(romanToInt(string));
    }

}
