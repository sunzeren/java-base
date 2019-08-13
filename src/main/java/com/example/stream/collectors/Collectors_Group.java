package com.example.stream.collectors;

/**
 * Author by Sun, Date on 2019/4/2.
 * PS: Not easy to write code, please indicate.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Hinsteny
 * @date 2017-12-11
 * @copyright: 2017 All rights reserved.
 */
public class Collectors_Group {

    // 短格式时间
    private static final String shortDate = "yyyyMMdd";

    public static void main(String[] args) {
        List<Book> books = Book.getBooks("Notre-Dame de Paris", "朝花夕拾", "朝花夕拾", "挪威的森林");
        books.stream().map(Book::getName).forEach(System.out::println);

        // 分组
        groupByName(books);

        books = new ArrayList<>();
        books.add(new Book("Notre-Dame de Paris", 86.9, parseDate(shortDate, "18310101")));
        books.add(new Book("朝花夕拾", 36.8, parseDate(shortDate, "19260211")));
        books.add(new Book("朝花夕拾", 36.8, parseDate(shortDate, "19260211")));
        books.add(new Book("挪威的森林", 30.5, parseDate(shortDate, "19870101")));
        // 分组后统计
        groupByNameCount(books);

        // 求一些分析值, 最大, 最小, 平均
        calculate(books);
    }

    /**
     * 按照指定的分组key进行分组
     *
     * @param books
     */
    private static void groupByName(List<Book> books) {
        // 按照书名分组
        // 按照指定的key分组,返回map
        Map<String, List<Book>> collect_one = books.stream().collect(Collectors.groupingBy((book) -> book.getName()));
        System.out.println(collect_one);
        // 按照书名分组, 但是要去重
        Map<String, Set<Book>> collect_two = books.stream().collect(Collectors.groupingBy((book) -> book.getName(), Collectors.toSet()));
        System.out.println(collect_two);
    }

    /**
     * 按照指定的规则分组并聚合统计
     *
     * @param books
     */
    private static void groupByNameCount(List<Book> books) {
        // 按书名分组, 统计每种数的总本书
        //此处的1相当于,一个Book对象算#{1}来计数
        Map<String, Integer> count = books.stream().collect(Collectors.groupingBy(book -> book.getName(), Collectors.summingInt(t -> 1)));
        System.out.println(count);
        // 按书名分组, 统计每种数的总价格
        Map<String, Double> count_2 = books.stream().collect(Collectors.groupingBy(book -> book.getName(), Collectors.summingDouble(book -> book.getPrice())));
        System.out.println(count_2);
        // 按照某个时间点进行分割, 统计二者总数
        Date split = parseDate(shortDate, "19000101");
        Map<Boolean, Integer> count_3 = books.stream().collect(Collectors.partitioningBy(book -> book.getTime().before(split), Collectors.summingInt(t -> 1)));
        System.out.println(count_3);
    }

    /**
     * 按照指定的规则分组统计
     *
     * @param books
     */
    private static void calculate(List<Book> books) {
        // 找出最晚发版的著作
        Comparator<Book> byLastPublish = Comparator.comparing((book -> book.getTime()));
        Optional<Book> book = books.stream().collect(Collectors.minBy(byLastPublish));
        System.out.println(book.orElseGet(null));
        // 找出书价最高的书
        //Comparator<Book> byMaxPrice = Comparator.comparing((_book -> -_book.getPrice()));
        Comparator<Book> byMaxPrice = Collections.reverseOrder(Comparator.comparing((_book -> _book.getPrice())));
        book = books.stream().collect(Collectors.minBy(byMaxPrice));
        System.out.println(book.orElseGet(null));
        // 算出所有书的平均书价
        Double averagePrice = books.stream().collect(Collectors.averagingDouble((__book -> __book.getPrice())));
        System.out.println(averagePrice);
    }

    /**
     * 解析时间字符串
     *
     * @param format
     * @param dateStr
     * @return
     */
    public static Date parseDate(String format, String dateStr) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}

