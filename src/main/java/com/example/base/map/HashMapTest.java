package com.example.base.map;


import com.example.base.bean.Person;
import com.example.base.string.Test;

import java.util.*;

/**
 * Author by Sun, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name", "孙泽仁");
        map.put("name", "szr");
        map.put("gender", "男");

        map.put("phone", "110");
        map.put("say", "hello word !");

        //迭代map的values
        eachMapValues(map);
        //使用lambda表达式,迭代map时做某些事
        eachMapDoSomething(map);
        //mapEntrySet的迭代
        mapEntrySet(map);

        Runnable aNew = Person::new;
    }

    /**
     * mapEntrySet的迭代
     * */
    public static void mapEntrySet(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> stringEntry : map.entrySet()) {
            String key = stringEntry.getKey();
            String value = stringEntry.getValue();
            System.out.println("key:"+key+":"+"value:"+value);
        }
    }

    /**
     * 使用lambda表达式,迭代map时做某些事
     * */
    public static void eachMapDoSomething(Map<String, String> map) {
        Collection<String> values = map.values();
        //iterator是单向的
        Iterator<String> iterator = values.iterator();
        //将iterator所有的值保存入keySet中
        Set<String> valueSet = new HashSet<>();
        // values.forEach(valueSet::add);
        iterator.forEachRemaining(valueSet::add);
        for (String s : valueSet) {
            System.out.println(s);
        }
    }

    /**
     * 迭代map的所有值
     **/
    public static void eachMapValues(Map<String, String> map) {
        Collection<String> values = map.values();
        // values.remove("110");
        // for (String value : values) {
        //     System.out.println(value);
        // }
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
