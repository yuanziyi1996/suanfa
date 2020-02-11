package LeeCode.链表;

import java.util.ArrayList;
import java.util.List;

public class 多个数字拼成最小数字 {
    static String PrintMinNumber(int [] numbers) {
        if (numbers.length==0|| numbers ==null) {
            return "";
        }
        List<Integer> list=new ArrayList<>();
        for(int a:numbers) {
            list.add(a);
        }
        list.sort((a,b)->(a+""+b).compareTo(b+""+a));
        StringBuffer stringBuffer=new StringBuffer();
        for(int a:list) {
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] numbers= {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }

}
