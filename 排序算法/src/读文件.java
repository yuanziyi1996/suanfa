import java.io.*;

public class 读文件 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("c:" + File.separator + "eclipse"
                        + File.separator + "artifacts.xml"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:"
                + File.separator + "eclipse" + File.separator + "1.txt"));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}