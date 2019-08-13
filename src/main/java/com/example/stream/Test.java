package com.example.stream;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author by Sun, Date on 2019/3/25.
 * PS: Not easy to write code, please indicate.
 */
public class Test {

    private static HashMap<String,String>  map= new HashMap();
    private static List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6,3);

    static{
        map.put("name", "szr");
        map.put("gender", "man");
        map.put("age", "21");
    }

    public static void main(String[] args) {
        Test test = new Test();
        // test.sout10();
        // test.streamCountTest();
        // test.mapTest();

        Set<String> keySet = map.keySet();
        //匹配某值,返回boolean
        test.anyMathTest(keySet);
        //查找,并返回
        // test.findTest(keySet);
        //判断是否为空
        // test.firstIsEmpty(keySet);

        // test.streamMapTest();
        test.collectors();
    }


    /**
     * 1.使用stream流的map方法,将集合声明的类型,转换为新的对象返回Stream<新>
     * 2.将Stream流转换为集合
     */
    private void streamMapTest() {
        Set<String> collect = nums.stream()
                .map(String::valueOf)//1.将nums集合转换为String类型
                .collect(Collectors.toSet());//2.将流转换为Set集合
        // Set<String> collect = nums.stream().map(integer -> String.valueOf(integer)).collect(Collectors.toSet());
    }

    /**
     * 匹配
     */
    private void anyMathTest(Set<String> set){
        //进行一些处理,并返回boolean值
        //所有集合中的元素值都满足{}表达式(即包含g字母)才返回true
        set.stream().allMatch(s -> s.matches("g"));
        //集合中任意元素满足表达式则返回true
        set.stream().anyMatch(s -> s.equals("name"));
        //集合中没有该元素则返回true
        set.stream().noneMatch(s -> s.equals("none"));
    }

    /**
     * 查找,并返回
     */
    private void findTest(Set<String> set){
        //根据条件过滤,并返回第一个元素的值
        set.stream().filter(s -> s.equals("age")).findFirst().get();
        //根据元素过滤,如果不存在则返回其他值
        set.stream().findFirst().orElse("age");
    }

    /**
     * 判断是否为空
     * */
    private void firstIsEmpty(Set<String> set){
        set.stream().findFirst().isPresent();
    }

    /**
     * 遍历map
     */
    private void mapTest() {
        HashMap<String,String> map = new HashMap<>();
        map.put("name", "szr");
        map.put("gender", "man");
        map.put("age", "21");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.stream().forEach(s->System.out.println(s.getKey()+":"+s.getValue()));
    }

    /**
     * 输出1-10
     **/
    private void sout10() {
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }

    /**
     * 过滤null值,并去重聚合
     * */
    private void streamCountTest() {
        System.out.println(nums.stream().filter(num -> num != null).distinct().count());
    }


    /**
     * collectors
     * collect:收集
     * */
    private void collectors(){
        List<String> strs = Arrays.asList("aaa", "bbb", "aaa", "ddd");
        List<Integer> nums = Arrays.asList(4,5,1);

        List<String> newstr = strs.stream().collect(Collectors.toList());

        System.out.println("Collectors转成list:" + newstr);

        Set<String> newset = strs.stream().collect(Collectors.toSet());
        System.out.println("Collectors转成set:" + newset);

        String newstring = strs.stream().collect(Collectors.joining(","));
        System.out.println("将所有字符串合并起来:" + newstring);

        Double avg = nums.stream().collect(Collectors.averagingDouble(value -> value.doubleValue()));
        System.out.println("nums平均数为:"+avg);

        Integer maxNum = nums.stream().max(Integer::compareTo).get();
        // Integer maxNum = nums.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println("nums最大值"+maxNum);

        Integer minNum = nums.stream().min(Integer::compareTo).get();
        System.out.println("nums最小值"+minNum);
    }
}
