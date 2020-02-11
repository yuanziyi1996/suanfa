package java8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleList {
  private static List<String> items = new ArrayList<>();

  static {
    items.add("A");
    items.add("BC");
    items.add("C");
    items.add("BD");
    items.add("E");
    items.add("A");
  }

  public static void main(String[] args) {
    System.out.println(items);
    List<String> out = items.stream().distinct().collect(Collectors.toList());
    System.out.println(out);
    //Java8之前操作List
    for(String item:items){
      System.out.println(item);
    }

    //Java8 lambda遍历list
    System.out.println("java遍历list");
    items.forEach(c-> System.out.println(c));

    items.forEach(item->{
      if("C".equals(item)){
        System.out.println(item);
      }
    });

    System.out.println("--------");

    //先过滤
    items.stream().filter(s->s.contains("B")).forEach(c1-> System.out.println(c1));

  }
}
