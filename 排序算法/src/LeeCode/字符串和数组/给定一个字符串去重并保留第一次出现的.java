package LeeCode.字符串和数组;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class 给定一个字符串去重并保留第一次出现的{
    /*public  static  char[] solution(String str){
        int  length=str.length();
        int count =0;
        char a[]=str.toCharArray();
        for(int i=0;i<length-1;i++){
            for (int j=i+1;j<length-count;j++) {
                if (a[j] == a[i]) {
                    count++;
                    for (int k=j;k<length-1;k++){
                        a[k] = a[k + 1];
                    }

                }
            }
        }

            char[] b= Arrays.copyOf(a,length-count);
        return b;
    }*/

    public  static  TreeMap solution(String str) {
        char a[] = str.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : a) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            /*if (entry.getKey() > 1)
                it.remove();//使用迭代器的remove()方法删除元素*/
            System.out.println("entry.getKey() = " + entry.getKey());
        }
        return map;
    }
    public static void main(String[] args) {
        {
            TreeSet<String> tr = new TreeSet<String>();
            String[] s ={"11","22","22","33","33","33"};
            System.out.print("====处理前=======");
            for(int i=0;i<s.length;i++){
                System.out.print(s[i]+" ");
                tr.add(s[i]);
            }
            System.out.println(tr.size());
            String[] s2= new String[tr.size()];
            System.out.println("=====处理后======");
            for(int i=0;i<s2.length;i++){
                s2[i]=tr.pollFirst();//从TreeSet中取出元素重新赋给数组
                System.out.print(s2[i]+" ");
            }
        }
        
    }
}
