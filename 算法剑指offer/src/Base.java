import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.bind.SchemaOutputResolver;

class Base{


    public static void main(String[] args) {
        int a = Integer.parseInt("1024");

        int b = Integer.valueOf("1024").intValue();
        System.out.println(a);
        System.out.println("b = " + b);
    }
}
