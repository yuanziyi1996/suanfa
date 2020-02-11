package LeeCode.字符串和数组;

import java.util.Scanner;

public class 大佬的循环节 {
    public static void main(String[] args) {
        int i,m,n,r,t;
        Scanner scanner =new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        int p[]=new int [m*n];
        int q[]=new int[m*n];

        for(i=0;i<m*n;i++) //给数组p初始化值全为-1
        {
            p[i]=-1;
            q[i]=0;
        }



        t=0; //初始化值
        r=m; //把被除数赋给r

        while(r!=0&&(p[r]==-1)) //循环条件当r不为0且p[r]=-1时执行循环体
        {
            p[r]=t;             //余数r第一次出现的位置
            r=10*r;             //把被除数扩大10倍，以至于取第一个小数

            t++;
            q[t]=r/n;           //计算小数点后t位的值：取整，即为m/n的小数从小数点开始逐个取出放到数组q中
            r=r%n;              //算完一位就去掉一位，即取余对n
        }
        System.out.println("m/n = 0.");
        //因为m<n,所以m/n整数部分0,所以先输出'0.'
        if (r!=0)               //被除数不为0就执行以下语句
        {
            for(i=1;i<=p[r];i++)
                System.out.print(q[i]);//输出循环小数中前面非循环的部分

            System.out.print("（ ");            //输出循环的小数放在括号中

            for(i=p[r]+1;i<=t;i++)
                System.out.print(q[i]);

            System.out.print("） ");
        }
        else                    //被除数为0的情况
            for(i=1;i<=t;i++)    //输出不循环的小数
                System.out.println(q[i]);

    }
}
