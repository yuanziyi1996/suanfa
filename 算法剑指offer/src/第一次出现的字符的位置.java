
import java.util.*;

public class 第一次出现的字符的位置 {


    public static  int FirstNotRepeatingChar(String str) {
        char [] a=str.toCharArray();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for(char c:a){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        ArrayList<Character> list = new ArrayList<Character>();
        for(Map.Entry<Character,Integer> entry:entrySet){
            if(entry.getValue()==1)
                list.add(entry.getKey());
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<list.size();j++){
                if(a[i]==list.get(j))
                    return i;//返回的是第一次出现的字符的位置。我是用for a.length来看是哪一个
            }
        }
        return -1;

}

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("goeoglellla"));

    }
    }
