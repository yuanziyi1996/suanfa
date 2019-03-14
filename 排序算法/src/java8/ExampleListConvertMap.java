package java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleListConvertMap {

  private static List<Person> personList = Lists.newArrayList();

  static{
    personList.add(Person.builder().id(20).name("zhangsan").address("shanghai").build());
    personList.add(Person.builder().id(30).name("lisi").address("nanjing").build());
  }

  public static void main(String[] args) {
    //Java8 List转换Map toMap方法中的(value->value)第二个value指代的就是personList中的具体的值
    Map<Integer,Person> map_ = personList.stream().collect(Collectors.toMap((key->key.getId()),(value->value)));
    map_.forEach((key,value)-> System.out.println(key + ":" + value));

    personList.forEach(a->System.out.println(a));//Person(id=20, name=zhangsan, address=shanghai)
                                                // Person(id=30, name=lisi, address=nanjing)


   /* Map<Integer, Person> mappedMovies = personList.stream().collect(
      Collectors.toMap(Person::getRank, Person::getData));*/

  }
}
