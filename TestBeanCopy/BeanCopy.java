package cn.bitten.java.Reflex.bit;

import java.lang.reflect.Field;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class BeanCopy {
    
    /**
     * 将源对象中与目的对象相同属性，源对象的属性值copy赋值给目的对象
     * <p>
     * source:
     * name
     * age
     * birthday
     * <p>
     * target:
     * name
     * age
     *
     * @param source 源对象
     * @param target 目标对象
     */
    //source
    //
    public static void copy(Object source, Object target) throws IllegalAccessException {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Parameter source or target must be not null.");
        }
        Class classz1 = source.getClass();
        Class classz2 = target.getClass();

        Field[] fields1 = classz1.getDeclaredFields();

        Field[] fields2 = classz2.getDeclaredFields();
        for(Field s:fields1){
            for(Field t:fields2){
                t.toString();
                if (s.getName().equals(t.getName())) {
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        Object value = s.get(source);
                        t.set(target, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

    }
}
