package cn.edu.sustech;

public class test {

    public static void main(String[] args) {
        Container ioc=new ContainerImpl();

        ioc.register(aaa.class);
        ioc.register(bbb.class);
        ioc.register(ccc.class);
        aaa d=ioc.resolve(aaa.class);
        System.out.println(d.getBbb());

        System.out.println(d);

    }
}
