import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Arrays;

public class 全排列 {

        public static ArrayList<String> Permutation(String str) {
            char a[]=str.toCharArray();
            System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
            char b[]=a.clone();
            String string="";
            ArrayList<String> list=new ArrayList<String>();
            for(int i=0;i<a.length;i++){
                System.out.println(a[i]+"-------");
                string=String.valueOf(a[i]);
                System.out.println(string+"=========");
                for(int j=i;j<a.length-1;j++){
                    b[j]=b[j+1];
                }
                System.out.println(Arrays.toString(b)+"+++++++++");
                char[] c=new char[b.length-1];
                System.arraycopy(b,0,c,0,b.length-1);
                System.out.println(Arrays.toString(c)+"c数组");
                string=string+new String(c);
                list.add(string);
                b=a.clone();
            }
            return list;
        }

    public static void main(String[] args) {
        String string="abcd";
        ArrayList<String> list=new ArrayList<String>();
        list=Permutation(string);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
