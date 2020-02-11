package LeeCode.字符串和数组;

import java.util.Scanner;

public class 最大k {

    public static int solution(int a[],int k){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]<a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a[k-1];
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int b[]=new int[2];
        String str1=scanner.nextLine();
        String c1[]=str1.split(" ");
        for (int i=0;i<c1.length;i++){
            b[i]=Integer.parseInt(c1[i]);
        }
        String str=scanner.nextLine();
        String c[]=str.split(" ");
        int a[]=new int[c.length];
        for (int i=0;i<c.length;i++){
            a[i]=Integer.parseInt(c[i]);
        }
        System.out.println(solution(a,b[1]));

    }
}

