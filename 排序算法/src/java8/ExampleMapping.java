package java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 *Java8 Collectors.groupingBy and Collectors.mapping example
 */
public class ExampleMapping {

  private static List<Person> personList = Lists.newArrayList();
  static {
    personList.add(Person.builder().id(10).name("apple").address("shanghai").build());
    personList.add(Person.builder().id(12).name("apple").address("wuhan").build());
    personList.add(Person.builder().id(16).name("apple").address("nanjing").build());
    personList.add(Person.builder().id(200).address("hehe").build());
  }

  public static void main(String[] args) {
    //分组
    Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(c -> c.getAddress()));
    System.out.println(collect);
    Person person = null;
    Person person1=Person.builder().build();
    System.out.println(person);
    System.out.println(person1);
  }
}