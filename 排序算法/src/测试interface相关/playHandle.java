package 测试interface相关;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class playHandle implements ActionHandler{





  @Override
  public void getName() {
    System.out.println("play");
  }
}
