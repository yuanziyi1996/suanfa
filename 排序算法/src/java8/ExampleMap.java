package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleMap {

  private static Map<String, Integer> items = new HashMap<>();

  static {
    items.put("A", 10);
    items.put("B", 20);
    items.put("C", 30);
    items.put("D", 40);
    items.put("E", 50);
    items.put("F", 60);
  }

  public static void java8遍历map(Map<String, Integer> items){
    System.out.println("java8遍历map");
    items.forEach((key,value)-> System.out.println("key:" + key + " value:" + value));
  }

  public static void main(String[] args) {

    //Java8之前遍历是这样遍历map
    for(Map.Entry<String,Integer> entry:items.entrySet()){
      System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
    }

    //Java8遍历map
    java8遍历map(items);


    //使用entryset 修改内容
    items.entrySet().stream().filter(entry-> entry.getValue()>30).collect(Collectors.toSet()).forEach(field ->{
      System.out.println(field);
      field.setValue(100);
    });
    java8遍历map(items);

  }


}
