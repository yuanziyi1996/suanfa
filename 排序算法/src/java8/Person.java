package java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //这个用于提供get 和 Set方法
//加上了builder这个注解以后，就不用再书写getter和setter方法了 使用方式是 builder().id(XXXX).build()这样的方法
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private int id;
  private String name;
  private String address;


  public static <K, T> K getRank(T t) {
    return getRank(t);
  }

  public static <U, T> U getData(T t) {
    return getData(t);
  }
}
