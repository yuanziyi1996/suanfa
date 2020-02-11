package LeeCode.字符串和数组;

import sun.font.FontRunIterator;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public class 前面找一个最接近的 {
    public static void find(int [] a){
        int length = a.length;
        if(length==0 ||length==1){
            return;
        }

        Map<Integer,Integer> map =new HashMap();
        for (int i = 0; i <length ; i++) {
            map.put(i,a[i]);
        }

        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = i; j >0; j--) {
                if(map.get(j-1)> max && map.get(j-1)<a[i]){
                    max=map.get(j-1);
                }
            }

            System.out.println(a[i] +" -> "+max);
        }
    }

    public static void main(String[] args) {
        int a[]={1,5,4,8,7,9,10,6};
        find(a);
    }
}
