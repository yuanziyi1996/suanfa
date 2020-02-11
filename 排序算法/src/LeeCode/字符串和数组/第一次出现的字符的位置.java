package LeeCode.字符串和数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 第一次出现的字符的位置 {


    public static  int FirstNotRepeatingChar(String str) {
        char [] a=str.toCharArray();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int result = 0;
        for(int j = 0;j< a.length; j++){
            char c = a[j];
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
                result = j;//肯定是在这里，因为这里是第一次出现的。
            }
        }
        System.out.println(result);
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        ArrayList<Character> list = new ArrayList<Character>();
        for(Map.Entry<Character,Integer> entry:entrySet){
            if(entry.getValue()==1)
                list.add(entry.getKey());
        }
        System.out.println(list);
        for(int i=0;i<a.length;i++){
            if(list.contains(a[i])){
                return i;
            }
        }
        return -1;

}

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("goeocglellla"));

    }
    }
