import java.io.*;

/**
 * Created by on 2017/12/8.
 */
public class 文件有几行 {

    public static void main(String args[]) {
        try {
            FileReader read = new FileReader("C:"+File.separator+"2072242_all.txt");
            BufferedReader br = new BufferedReader(read);
            String row;

            int rownum = 1;
            while ((row = br.readLine()) != null) {
                rownum ++;
            }
            System.out.println("rownum="+rownum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}