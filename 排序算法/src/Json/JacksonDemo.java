package Json;


import java.util.ArrayList;
import java.util.List;


/**
 * 实例实现利用jackson实现实体对象与json字符串的互相转换
 * @author liangming.deng
 *
 */
public class JacksonDemo {
  public static void main(String[] args){

    UserBean userBean1 = new UserBean(1, "liubei", "123", "liubei@163.com");
    UserBean userBean2 = new UserBean(2, "guanyu", "123", "guanyu@163.com");
    UserBean userBean3 = new UserBean(3, "zhangfei", "123", "zhangfei@163.com");


    List<UserBean> userBeans = new ArrayList<>();
    userBeans.add(userBean1);
    userBeans.add(userBean2);
    userBeans.add(userBean3);

    DeptBean deptBean = new DeptBean(1, "sanguo", userBeans);
    //对象转json
    String userBeanToJson = JacksonUtil.toJson(userBean1);
    String deptBeanToJson = JacksonUtil.toJson(deptBean);

    System.out.println("deptBean to json:" + deptBeanToJson);
    System.out.println("userBean to json:" + userBeanToJson);

//    //json转字符串
//    UserBean jsonToUserBean = JacksonUtil.readValue(userBeanToJson, UserBean.class);
//    DeptBean jsonToDeptBean = JacksonUtil.readValue(deptBeanToJson, DeptBean.class);
//
//    System.out.println("json to DeptBean" + jsonToDeptBean.toString());
//    System.out.println("json to UserBean" + jsonToUserBean.toString());
//
//    //List 转json字符串
//    String listToJson = JacksonUtil.toJSon(userBeans);
//    System.out.println("list to json:" + listToJson);

//    //数组json转 List
//    List<UserBean> jsonToUserBeans = JacksonUtil.readValue(listToJson, new TypeReference<List<UserBean>>() {
//    });
//    String userBeanString = "";
//    for (UserBean userBean : jsonToUserBeans) {
//      userBeanString += userBean.toString() + "\n";
//    }
//    System.out.println("json to userBeans:" + userBeanString);
  }


}

