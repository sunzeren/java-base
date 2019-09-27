package com.example.time;

import java.time.LocalDateTime;

/**
 * Author by Sun, Date on 2019/5/16.
 * PS: Not easy to write code, please indicate.
 */
public class DateTimeDemo {

    private LocalDateTime now = LocalDateTime.now();

    public void test() {
        LocalDateTime myTime = LocalDateTime.of(2019, 5, 16, 15, 30);
        System.out.println("now = " + now);
        System.out.println("myTime = " + myTime);
    }

    /**
     * 常用操作方法
     */
    public void often() {
        //增加
        now.plusMonths(1);
        now.plusDays(1);
        now.plusHours(1);
        //减少
        now.minusDays(1);
        now.minusWeeks(1);
        now.minusHours(1);
        //判断
        now.isAfter(LocalDateTime.now());
        now.isBefore(LocalDateTime.now());
        //获取时间段
        now.getHour();
        now.getSecond();
        now.getMinute();
    }

}
