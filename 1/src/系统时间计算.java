import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 系统时间计算 {
    public static void main(String[] args) {
       // long a = 1542346083012;

        System.out.println();
        Date date=new Date(1542001298000L);
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d=df.format(date);
        System.out.println(d);
    }
}
