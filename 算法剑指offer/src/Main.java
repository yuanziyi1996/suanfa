import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String string1=scanner.nextLine();
        String a[]=string.split("->");
        String b[]=string1.split("->");
        String num1="";
        String num2="";
        for (int i=0;i<a.length;i++){
            num1+=a[i];
            num2+=b[i];
        }
        int num3=Integer.parseInt(num1);
        int num4=Integer.parseInt(num2);
        int num5=num3+num4;
        String s=String.valueOf(num5);
        String result = "";
        result+=s.charAt(0);
        for(int i=1;i<s.length();i++){
            result=result+"->"+s.charAt(i);
        }
        System.out.println(result);
    }
}
