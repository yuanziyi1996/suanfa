public class Hello {

  static {
    method();
  }

  private static boolean flag = false;

  public static void method(){
    System.out.println(System.currentTimeMillis());
    System.out.println(flag+"1");
    if(!flag){
      System.out.println("hello");
      flag=true;
    }
  }

  public static void main(String[] args) {
    System.out.println("start 1");
    method();
    System.out.println("start 2");
    method();
  }
}
