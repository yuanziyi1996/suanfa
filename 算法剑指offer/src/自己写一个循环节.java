import java.util.Scanner;

public class 自己写一个循环节 {

    /*      ①mod = a%b；

               ②小数 = （mod*10） / b；

               ③mod = （mod*10）%b；

       循环②③步，当出现重复的余数的时候，也就是循环节出现了

       我可以先
       */
    public static void main(String[] args) {
        int a, b, t, k;
        int book []=new int[3000]; //标记第一个余数
        int count [] = new int[3000];// 记录循环小数
        Scanner scanner = new Scanner(System.in);
        a=scanner.nextInt();
        b = scanner.nextInt();
        count[0] = a / b; // 小数点左边的数
        int mod=a%b;
        //下面开始写计算余数的部分
        for(int i=0;i<book.length;i++){
            count[i]=(mod*10)/b;
            mod=(mod*10)%b;
        }

        for(int i=0;i<count.length;i++){

        }


}
}


