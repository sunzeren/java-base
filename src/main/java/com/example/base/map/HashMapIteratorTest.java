package com.example.base.map;

import org.springframework.expression.spel.ast.ConstructorReference;

import java.util.*;

/**
 * Author by Sun, Date on 2019/3/4.
 * PS: Not easy to write code, please indicate.
 */
public class HashMapIteratorTest {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("name", "123");
        map.put("age", "12222");
        map.put("birthday", new Date());
        //遍历map
        // hashMapIterator(map);

        //并发修改错误演示
        hashMapKeySet(map);
        System.err.println("isOK!");
        System.out.println("is OK !");
    }



    private static void hashMapKeySet(Map<String, Object> map) {
        Set<String> keySet = map.keySet();
        for(Iterator<String> iterator = keySet.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println("key:"+next);
            //不可使用如下删除方法,必须使用iterator的方法,
            // iterator中只可删除,不可添加
            // keySet.add("sss");
            // keySet.remove("name");
        }
    }

    /**
     * @Author SuZeRen
     * @Description 遍历Map,遍历时,对返回的集合操作,Map也会随之改变
     * @Date 11:09 2019/3/4
     **/
    public static void hashMapIterator(Map<String,Object> map){

        //Set for循环遍历的时候，不能使用集合本身进行删除操作
        //需要使用迭代器iterator.remove();操作来删除,因为指向的引用不一致,导致索引差异,以至于无法完成循环抛出异常
        //因为该set与map是同一内存的不同引用,所以,操作在集合上,map也会有对应的改变
        System.err.println("map isEmpty :"+map.isEmpty());
        for (Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue()+" will be remove");
            //遍历时必须使用iterator.remove()删除
            iterator.remove();
            //TODO Sun 2019/3/11 iterator的迭代索引,iterator.hasNext(),iterator.next()
            //不能使用以下方法来删除,否则会抛出ConcurrentModificationException(并发修改异常)
            // map.remove("name");
            // map.entrySet().remove(map.entrySet().iterator().next());
            System.out.println("remove item success");
            System.out.println("----------------");
        }
        System.err.println("map isEmpty :"+map.isEmpty());
    }


}
