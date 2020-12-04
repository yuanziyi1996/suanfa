/**
 * @author ziyi.yuan
 * @date 2019-08-13 11:55
 */

import org.springframework.util.CollectionUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class 获取文件大小 {
  public static long getFileSize(String filename) {
    File file = new File(filename);
    if (!file.exists() || !file.isFile()) {
      System.out.println("文件不存在");
      return -1;
    }
    return file.length();
  }



  public static String getFile(String filename) {
    Path fpath= Paths.get(filename);
    StringBuffer strbuffer = new StringBuffer();
    //创建文件
    if(!Files.exists(fpath)) {
      try {
        Files.createFile(fpath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
      FileInputStream fis = new FileInputStream(filename);
      InputStreamReader inputStreamReader = new InputStreamReader(fis, "GBK");
      BufferedReader in  = new BufferedReader(inputStreamReader);

      String str;
      while ((str = in.readLine()) != null) {
        strbuffer.append(str);  //new String(str,"UTF-8")
      }
      in.close();
    } catch (IOException e) {
      e.getStackTrace();
    }
    return strbuffer.toString();
  }


  public static void main(String[] args) {
//    long size = getFileSize("/Users/ziyi/Desktop/无标题.txt");
//    System.out.println("java.txt文件大小为: " + size);
//    String string = getFile("/Users/ziyi/Desktop/无标题.json");
//    System.out.println(string);
    List<Long> longs = new ArrayList<>();
    System.out.println(CollectionUtils.isEmpty(longs));
  }
}
