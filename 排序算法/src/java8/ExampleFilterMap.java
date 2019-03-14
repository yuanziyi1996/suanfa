package java8;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.stream.Collectors;

public class ExampleFilterMap {

  private static Map<Integer,String> map_ = Maps.newHashMap();

  static{
    map_.put(1, "linode.com");
    map_.put(2, "heroku.com");
    map_.put(3, "digitalocean.com");
    map_.put(4, "aws.amazon.com");
  }

  public static void main(String[] args) {
    //before java iterator map
    String result = null;
    for(Map.Entry<Integer,String> entry:map_.entrySet()){
      if("heroku.com".equals(entry.getValue())){
        result = entry.getValue();
      }
    }

    System.out.println("Before Java 8 :" + result);

    //Java8 Map->Stream->Filter->String
    result =  map_.entrySet().stream().
      filter(map->"heroku.com".equals(map.getValue()))
      .map(map->map.getValue())
      .collect(Collectors.joining());
    System.out.println("Java 8 :" + result);

    Map<Integer,String> collect =  map_.entrySet().stream()
      .filter(c->c.getKey()==2) //这里就不用加map(map->map.getValue) 因为上者的返回类型是Sring类型，下面的是一个Map类型。
      .collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));//注意与ExampleListConvertMap类中的value->value区分
    System.out.println(collect);

  }
}
