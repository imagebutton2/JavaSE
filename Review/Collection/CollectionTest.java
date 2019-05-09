package Collection.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

//Collection的增(add)、删(remove)、查get()、改set
public class CollectionTest {

    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        //m=1
        list.add("h");
        //m=2
        list.add("e");
        //m=3
        list.add("l");
        //m=4
        list.add("l");
        //m=5
        list.add("d");
        System.out.println(list.get(3));
        System.out.println(list.set(3,"le"));
        System.out.println(list.get(3));
        //集合遍历
        //ex=m=5
        Iterator <String>iterator=list.iterator();
        while (iterator.hasNext()){
            String str=iterator.next();
            if(str.equals("l")){
                //m=6
                //ex=5
                list.remove(0);
            }
            System.out.println(str);
        }


    }
}
