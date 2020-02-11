import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class java反射 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");

        try{
            Class<?> mapType = map.getClass();
            Method capacity = mapType.getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            System.out.println("capacity : " + capacity.invoke(map));

            Field size = mapType.getDeclaredField("size");
            size.setAccessible(true);
            System.out.println(" size : "+ size.get(map));
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
