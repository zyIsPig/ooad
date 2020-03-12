package cn.edu.sustech;

import java.lang.reflect.Field;

public class test2 {

    public static void main(String[] args) throws IllegalAccessException {
        aaa aaa=new aaa();
        Class a=aaa.getClass();

        Field []fields=a.getDeclaredFields();
        for (Field f:fields
             ) {
            System.out.println(f);
            f.setAccessible(true);
            f.set(aaa,new bbb());
            f.setAccessible(false);

        }
        System.out.println(aaa);
    }
}
