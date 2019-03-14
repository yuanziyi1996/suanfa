package java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  private String name;
  private int salary;
  private String office;

  public static void main(String[] args) {
    Employee employee = Employee.builder().build();
    System.out.println(employee);
  }
}
