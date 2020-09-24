package cn.dqb.activemq;

import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQSession;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.jms.Session;

public class ClassUtil {
    public static Object getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //设置对象的访问权限，保证对private的属性的访问
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {

            return null;
        }
    }

    public static void readAttributeValue(Object obj) {
        String nameVlues = "";
        //得到class
        Class cls = obj.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//遍历
            try {
                //得到属性
                Field field = fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                String name = field.getName();
                //获取属性值
                Object value = field.get(obj);

                //一个个赋值
                nameVlues += field.getName() + ":" + value + ",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //获取最后一个逗号的位置
        int lastIndex = nameVlues.lastIndexOf(",");

        //不要最后一个逗号","
        String result = nameVlues.substring(0, lastIndex);
        System.out.println(result);
    }
}
