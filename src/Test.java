import com.bgamq.Dog;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception{


       /* Dog dog = new Dog();
        Field name = dog.getClass().getField("name");
        name.set(dog,"zhangsan");*/

        Class aClass = Class.forName("com.bgamq.Dog");
        Object obj = aClass.newInstance();


        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(obj,"zhangsan");
        }

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.out.println(field.get(obj));
        }




        /*Field[] declaredFields = dog.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(obj));
        }*/


    }
}
