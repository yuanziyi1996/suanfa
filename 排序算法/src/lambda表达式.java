import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class lambda表达式 {
  public static void main(String[] args) {

    test1();

    List<Emp> list = Arrays.asList(new Emp("a"), new Emp("b"), new Emp("c"));
    list.stream().map(emp -> emp.getName()).forEach(str -> {
      System.out.println(str);
    });

  }

  public static void test1() {
    String[] dd = {"a", "b", "c"};
    Stream<String> stream = Arrays.stream(dd);
    stream.filter(a -> a.equals("a")).forEach(System.out::println);//返回字符串为a的值
  }

  public static class Emp {
    private String name;

    public Emp() {
      super();
    }

    public Emp(String name) {
      super();
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
