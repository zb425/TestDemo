package com.bgamq.reflect;



import com.bgamq.annotaion.AutoWrid;
import com.bgamq.annotaion.Bean;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext<T> {

    private  Map<Class,Object> beanFactory=new HashMap<>();
    private String filePath;


    public T getBean(Class clazz){
        return  (T)beanFactory.get(clazz);
    }

    /**
     * 通过配置进行ioc配置
     */
    /*public void initContext(){
        InputStream resource = ApplicationContext.class.
                getClassLoader().getResourceAsStream("config/bean.config");

        Properties properties = new Properties();
        try {
            properties.load(resource);
            Set<Object> keySet = properties.keySet();
            for (Object key : keySet) {
                beanFactory.put(Class.forName(key.toString()),
                        Class.forName(properties.getProperty(key.toString())).newInstance());
                System.out.println(key.toString()+"========"+properties.getProperty(key.toString()));
            }
        }catch (Exception e){
            
        }
    }*/

    //加载全部的类的实例
    public  void initContextByAnnotation()  {
        filePath = ApplicationContext.class.getClassLoader().getResource("").getFile();
        loadOne(new File(filePath));

        assembleObject();
    }

    private void assembleObject() {
        for(Map.Entry<Class,Object> entry : beanFactory.entrySet()){
            //就是咱们放在容器的对象
            Object obj = entry.getValue();
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields){
                AutoWrid annotation = field.getAnnotation(AutoWrid.class);
                if( annotation != null ){
                    field.setAccessible(true);
                    try {
                     //   System.out.println("正在给【"+obj.getClass().getName()+"】属性【" + field.getName() + "】注入值【"+ beanFactory.get(field.getType()).getClass().getName() +"】");
                        field.set(obj,beanFactory.get(field.getType()));

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * 加载一个文件夹的类
     * @param fileParent
     */
    private  void loadOne(File fileParent) {
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            for (File child : childrenFiles) {
                if (child.isDirectory()) {
                    //如果是个文件夹就继续调用该方法,使用了递归
                    loadOne(child);
                } else {
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                    //选中class文件
                    if (pathWithClass.contains(".class")) {
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);

                            //把非接口的类实例化放在map中
                            if(!aClass.isInterface()){
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                if(annotation != null){
                                    Object instance = aClass.newInstance();
                                    //判断一下有没有接口
                                    if(aClass.getInterfaces().length > 0) {
                                        //如果有接口把接口的class当成key，实例对象当成value

                                        beanFactory.put(aClass.getInterfaces()[0], instance);
                                    }else{
                                        //如果有接口把自己的class当成key，实例对象当成value
                                        beanFactory.put(aClass, instance);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
