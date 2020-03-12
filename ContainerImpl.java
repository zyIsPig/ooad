package cn.edu.sustech;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

public class ContainerImpl implements Container {

    private Map<Class,Class> map;

    public Map<Class, Class> getMap() {
        return map;
    }

    public ContainerImpl() {
        this.map = new HashMap<>();
    }

    public void setMap(Map<Class, Class> map) {
        this.map = map;
    }

    @Override
    public <T> void register(Class<T> serviceType) {


        //不能为空

        if(serviceType==null){
            throw new IllegalArgumentException();

        }
        //是接口或者抽象类
        if(serviceType.isInterface() || Modifier.isAbstract(serviceType.getModifiers())){
            throw new IllegalArgumentException();


        }

        //多个构造函数
        if(serviceType.getConstructors().length>1){
            throw new IllegalArgumentException();
        }

        map.put(serviceType,null);


    }

    @Override
    public <T> void register(Class<T> serviceType, Class<? extends T> implementationType) {
        //都不能为空
        if(serviceType==null || implementationType==null){
            throw new IllegalArgumentException();

        }
        //servicetype应为接口或者抽象类
        if(!serviceType.isInterface() && !Modifier.isAbstract(serviceType.getModifiers())){
            throw new IllegalArgumentException();
        }
        //iml不应该为抽象类和接口
        if(implementationType.isInterface() || Modifier.isAbstract(implementationType.getModifiers())){
            throw new IllegalArgumentException();

        }

        if(implementationType.getConstructors().length>1){
            throw new IllegalArgumentException();

        }

        //只保留最后一次

        if(map.containsKey(serviceType)){
            map.replace(serviceType,implementationType);

        }else {
            map.put(serviceType, implementationType);
        }

    }

    @Override
    public <T> T resolve(Class<T> serviceType) {

        if(serviceType==null){
            throw new IllegalArgumentException();

        }

        //判断是否注册
        if(!map.containsKey(serviceType)){
            throw new ServiceNotFoundException();

        }


      //this service is a domain class
        try{
            Class target;
            if(map.get(serviceType)==null){
                target=serviceType;
            }
            else {
                target=map.get(serviceType);
            }





            Constructor[] constructors = target.getDeclaredConstructors();
            //if not exist constructors


//            Arrays.stream(constructors).forEach(System.out::println);
            Class[] fieldTypes = constructors[0].getParameterTypes();
//            Arrays.stream(fieldTypes).forEach(System.out::println);
            Object[] objects = new Object[fieldTypes.length];

            for (int i = 0; i < fieldTypes.length; i++) {
                Class tempClass = fieldTypes[i];



                //objects[i] = tempClass.getDeclaredConstructor().newInstance();
                objects[i]=this.resolve(tempClass);



            }
            Object b=target.getDeclaredConstructors()[0].newInstance(objects);


            //注入

           //while循环获取所有父类的属性
            List<Field> fields=new ArrayList<>();

            Class otemp=b.getClass();
            while(otemp!=Object.class){

                fields.addAll(Arrays.asList(otemp.getDeclaredFields()));
                otemp=otemp.getSuperclass();

            }



            //递归生成所有注解过的属性

            for (Field f:fields){

                if(f.getAnnotation(Inject.class)!=null){

                    if(f.isAccessible()){
                        //该类是可获取的（public），可以直接进行set修改

                        f.set(b,this.resolve(f.getType()));



                    }
                    else {
                        //该类不可获取（private ｜｜ protect），要先设置成可获取然后修改值最后在设置为不可获取

                        Object o=this.resolve(f.getType());

                        f.setAccessible(true);
                        //修改值
                        f.set(b,o);


                        f.setAccessible(false);
                    }

                }

            }

            return (T) b;



        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



        return null;


    }
}
