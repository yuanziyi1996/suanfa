package java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class test {
  private String name;
  private int salary;
  private String office;


  public static boolean isOdd(int i) {
    return i % 2 != 0;
  }


  public static void main(String[] args) {
     long start = System.currentTimeMillis();
    System.out.println(isOdd(-1)+"用时："+(System.currentTimeMillis()-start));
  }

}
