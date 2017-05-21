package org.sergei._0_core._3_io._1_io.adapter;

import java.util.Arrays;

/**
 * Created by Sergei on 06.03.2015.
 */
public class Person {
    private final String name;
    private final int age;
    private final Sex[] sex;

    public enum Sex {F, M}

    public Person(String name, int age, Sex[] sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex[] getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + Arrays.toString(sex) +
                '}';
    }
}
