package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TimSort {
  public static void main(String[]args) {
    Integer[] array =
      {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,22,2,2,2,2,2,22,2,2,2};
    List<Integer> list = Arrays.asList(array);
    List<Date> arr=new ArrayList<>();
    Date date = new Date();
    Date date2 = date;
    arr.add(date);
    arr.add(date2);
    //arr.add(date2);
    list.sort((a,b)->{
        System.out.print(a);
        System.out.print(b);
        return a.compareTo(b);
      }
    );
  }
}
