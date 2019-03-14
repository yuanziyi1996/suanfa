import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkName {
    public static boolean checkName(String NAME){
        boolean flag = false;
        try{
            String check = "^(?![!@#$%^&*]+$)[[\u4E00-\u9FA5A-Za-z]+(•[\u4E00-\u9FA5A-Za-z]+)]{1,20}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(NAME);
            flag = matcher.matches();
            System.out.println(flag);
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkName("1111"));
    }
}
