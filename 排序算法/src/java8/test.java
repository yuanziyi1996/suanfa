package java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class test {
  private String name;
  private int salary;
  private String office;

  public static void main(String[] args) {
    System.out.println(new test());
  }
}
