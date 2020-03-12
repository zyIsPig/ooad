package cn.edu.sustech;

public class test3 {
    public static void main(String[] args) {
        Container container=new ContainerImpl();
        Class c=interImpl.class;

//        System.out.println(c.getConstructors().length);
        container.register(inter.class,interImpl.class);

        Object o=container.resolve(inter.class);
        System.out.println(o);

    }
}
