package com.example.stream.collectors;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Hinsteny
 * @date 2017-12-11
 * @copyright: 2017 All rights reserved.
 */
public class Book {

    /**
     * 书名
     */
    private String name;

    /**
     * 书价
     */
    private double price;

    /**
     * 出版时间
     */
    private Date time;

    public Book(String name) {
        this(name, 0D);
    }

    public Book(String name, double price) {
        this(name, price, new Date());
    }

    public Book(String name, double price, Date time) {
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }

    @Override
    public int hashCode() {
        String book = "";
        if (null != this.name) {
            book += this.name;
        }
        book += String.valueOf(this.price);
        if (null != this.time) {
            book += String.valueOf(this.time);
        }
        return book.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Book) {
            result = true;
            Book book = (Book) obj;
            if (result && null != this.name ) {
                result = this.name.equals(book.getName());
            }
            if (result) {
                result = this.price == book.getPrice();
            }
            if (result && null != this.getTime() ) {
                result = this.time.equals(book.getTime());
            }
        }
        return result;
    }

    public static List<Book> getBooks(String ... books) {
        List<Book> _books = new ArrayList<>();
        for (String book : books) {
            Book item = new Book(book);
            _books.add(item);
        }
        return _books;
    }
}

