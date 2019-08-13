package com.example.base.iterator;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * Author by Sun, Date on 2019/3/26.
 * PS: Not easy to write code, please indicate.
 */
public class SpliteratorTest {
    public static void main(String[] args) {
        SpliteratorTest spliteratorTest = new SpliteratorTest();
        ArrayList list = new ArrayList();
        spliteratorTest.test(list);
    }

    private void test(ArrayList list) {
        for (int i = 0; i <100 ; i++) {
            list.add("test"+i);
        }
        Spliterator spliterator = list.spliterator();
        int count =0;
        //分割后剩余的Spliterator
        Spliterator surplus = null;
        Spliterator test = null;
        //如果有剩余则消费且返回true
        while(spliterator.tryAdvance(System.out::println)){
            if(count==0) {
                //返回的surplus拥有所有的元素,保留该处理的下标index
                //既,将下标index跳跃一半数据长度,返回的spliterator保留原处理下标
                //如:spliterator 进入循环后消费过一次所以,index为1,数据长度为100,fence为100,则原spliterator索引变为50,
                // 返回的spliterator(surplus),为当前未处理的index,1,fence(限制操作的边界)为50
                //ArrayListSpliterator本质上还是对原list进行操作，只是通过index和fence来控制每次处理范围
                surplus = spliterator.trySplit();
            }
            count++;
        }
        System.out.println(count);
        System.out.println("---");
        surplus.forEachRemaining(System.out::println);

        //返回给定spliterator的特征值,与索引index无关,与内容有关
        int characteristics = surplus.characteristics();
        int characteristics_full = spliterator.characteristics();
        //判断一个特征值在此spliterator是否存在
        System.out.println(spliterator.hasCharacteristics(characteristics));
        System.out.println(surplus.hasCharacteristics(characteristics_full));
    }
}
