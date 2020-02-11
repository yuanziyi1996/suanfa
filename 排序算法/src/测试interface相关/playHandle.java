package 测试interface相关;

import java8.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class playHandle implements ActionHandler{





  @Override
  public void getName() {
    System.out.println("play");
  }
}
