package com.example.util.beantomap;

import com.example.util.bean.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * BEAN、MAP互转工具类<br>
 * <p>
 * 当把Person类作为BeanToMapUtils的内部类时，程序出错<br>
 * java.lang.NoSuchMethodException: Property '**' has no setter method<br>
 * 本质：内部类 和 单独文件中的类的区别 <br>
 * BeanUtils.populate方法的限制：<br>
 * The class must be public, and provide a public constructor that accepts no arguments. <br>
 * This allows tools and applications to dynamically create new instances of your bean, <br>
 * without necessarily knowing what Java class name will be used ahead of time
 */
public class BeanToMapUtils {
    private static Logger log = LoggerFactory.getLogger(BeanToMapUtils.class);

    public static void main(String[] args) {

        Person person = new Person();
        Map<String, Object> mp = new HashMap(16);
        mp.put("Pname", "123");
        mp.put("age", "12222");
        mp.put("birthday", new Date());

        // 将map转换为bean
        transMap2Bean(mp, person);

        System.out.println("--- transMap2Bean Map Info: ");
        for (Map.Entry<String, Object> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("--- Bean Info: ");
        System.out.println("name: " + person.getName());
        System.out.println("age: " + person.getAge());

    }

    // Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean
    public static void transMap2Bean2(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            log.error("transMap2Bean2 Error ", e);
        }
    }

    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    public static void transMap2Bean(Map<String, Object> map, Object obj) {

        try {
            //获取类的详情
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            //类的每个属性的详情 数组
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                //获取obj字段的名称
                String key = property.getName();

                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }

            }

        } catch (Exception e) {
            log.error("transMap2Bean Error ", e);
        }

        return;

    }

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            log.error("transBean2Map Error ", e);
        }

        return map;

    }
}
