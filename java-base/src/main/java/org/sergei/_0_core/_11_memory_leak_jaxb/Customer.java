package org.sergei._0_core._11_memory_leak_jaxb;

import javax.xml.bind.annotation.*;

/**
 * Created by Sergei_Admin on 12.03.2016.
 */

@XmlRootElement
public class Customer {

    String name;
    int age;
    int id;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}