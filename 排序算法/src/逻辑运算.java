public class 逻辑运算 {
  public static void main(String[] args) {
    int a=1;
    int b=2;
    int c=4;
    int d=16;
    int e=256;
    int f=261;
    System.out.println(a&f);//1
    System.out.println(c&f);//4
    System.out.println(d&f);//0
    System.out.println(a|c|e);//261
    System.out.println(1|3);//3
    System.out.println(1&4);//0
  }
}
