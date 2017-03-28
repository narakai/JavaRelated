import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        //false： 基于插入顺序
//        Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, false);
//        map.put("1", "a");
//        map.put("2", "b");
//        map.put("3", "c");
//        map.put("4", "d");
//
//        //访问其中的两个对象
//        map.get("1");
//        map.get("2");
//
//        for (Iterator<String> iterator = map.values().iterator(); iterator
//                .hasNext(); ) {
//            String name = (String) iterator.next();
//            System.out.print(name);
//        }

        //http://www.jianshu.com/p/e5c3b522e8c5

//        true： 基于访问顺序, get一个元素后，这个元素被加到最后
        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        //访问其中的两个对象
        map.get("1");
        map.get("2");

        for (Iterator<String> iterator = map.values().iterator(); iterator
                .hasNext();) {
            String name = (String) iterator.next();
            System.out.print(name);
        }
    }
}
