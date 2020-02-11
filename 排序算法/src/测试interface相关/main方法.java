package 测试interface相关;

import java.util.ArrayList;
import java.util.List;

public class main方法 {
  public static void main(String[] args) {


    ActionHandler actionHandler1 = playHandle.builder().build();
    ActionHandler actionHandler = sayHandle.builder().build();

    List<ActionHandler> list = new ArrayList<>();
    list.add(actionHandler);
    list.add(actionHandler1);

    for (ActionHandler a : list) {
      a.getName();
    }
  }
}
