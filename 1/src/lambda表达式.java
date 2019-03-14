import java.util.Arrays;
import java.util.stream.Stream;

public class lambda表达式 {
  public static void main(String[] args) {
    test1();
  }
  public static void test1(){
    String[] dd = { "a", "b", "c" };
    Stream<String> stream = Arrays.stream(dd);
    stream.filter(str -> str.equals("a")).forEach(System.out::println);//返回字符串为a的值
  }
}
