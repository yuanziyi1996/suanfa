package LeeCode.字符串和数组;

import java.util.Scanner;

public class 求循环节 {
    /*      ①mod = a%b；

            ②小数 = （mod*10） / b；

            ③mod = （mod*10）%b；

    循环②③步，当出现重复的余数的时候，也就是循环节出现了

    我可以先
    */
    public static void main(String[] args) {
        int a, b, t, k, i;
        int book []=new int[3000]; //标记第一个余数
        int count [] = new int[1000];// 记录循环小数
        Scanner scanner = new Scanner(System.in);
        a=scanner.nextInt();
        b = scanner.nextInt();

        count[0] = a / b; // 小数点左边的数
        t = a%b; // 余数
        book[t] = 1; // 记下第一个余数

        count[1] = (t * 10) / b; // 小数点后一位数
        t = (t*10)%b; //继续求余

        k = 2;
        while (book[t] == 0) {  //循环直到出现 第一次出现 的 余数
            count[k] = (t * 10) / b;
            t = (t*10)%b;
            k++;
        }


        for (i = 1; i < k; i++){
            System.out.println(count[i]);
        }




    }
}
