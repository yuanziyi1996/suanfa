import java.util.ArrayList;
import java.util.List;

public class list数据类型 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String l:list
             ) {
            System.out.println(l);
        }
        System.out.println(list);
    }

}
