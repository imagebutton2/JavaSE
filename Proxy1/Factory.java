package cn.bitten.java.Reflex.My;

import java.lang.reflect.Constructor;

public class Factory {
    private Factory() {
    }

    public static <T> T  getInstance(String className) {
        T t=null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
    public static <T> T  getInstance(String className,Object object) {
        T t=null;

            try {
                Constructor constructor = Class.forName(className).getConstructor(object.getClass().getInterfaces()[0]);
                t = (T) constructor.newInstance(object);
            } catch (Exception e) {
                e.printStackTrace();
            }


        return t;
    }
}
