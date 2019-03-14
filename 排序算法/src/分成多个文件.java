import java.io.*;

/**
 * Created by  on 2018/10/24.
 * @author yuanziyi
 */
public class 分成多个文件 {

    public static void main(String args[]) {
        try {
            Reader reader = new InputStreamReader(new FileInputStream("E:"+File.separator+"1.txt"));
            FileReader read = new FileReader("E:"+File.separator+"1.txt");
            BufferedReader br = new BufferedReader(read);

            int rownum = 1;

            int fileNo = 1;
            FileWriter fw = new FileWriter("D:/xxsql/text"+fileNo +".sql");
            int temp;
            while ((temp= reader.read()) != -1) {
                fw.append((char)temp);

                if(((char) temp) == ';'){
                    fw.close();
                    fileNo ++ ;
                    fw = new FileWriter("D:/xxsql/text"+fileNo +".sql");
                }
            }
            fw.close();
            System.out.println("rownum="+rownum+";fileNo="+fileNo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}