package Collection.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(10,"world");
        map.put(100,"bit");
        map.put(10,null);
        map.put(null,null);
        System.out.println(map.get(10));
        System.out.println(map.get(200));
        //Map--->Set
        Set<Map.Entry<Integer,String>>entrySet=map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String>entry=iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
