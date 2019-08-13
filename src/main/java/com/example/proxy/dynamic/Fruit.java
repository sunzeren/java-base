package com.example.proxy.dynamic;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public enum Fruit {
    apple("苹果", 1), bnanaa("香蕉", 2), orange("橘子", 3), watermelon("西瓜", 4);

    String name;
    int index;
    String value;

    Fruit(String name, int i) {
        this.name = name;
        this.index = i;
        this.value = name;
    }

    public static String getName(int index) {
        for (Fruit o : Fruit.values()) {
            if (o.getIndex() == index) {
                return o.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
