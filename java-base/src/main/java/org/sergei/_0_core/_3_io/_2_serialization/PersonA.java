package org.sergei._0_core._3_io._2_serialization;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Sergei on 10.03.2015.
 */
public class PersonA implements Serializable {
    private final String name;
    private final transient int age;
    private Address address;

    public PersonA(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);

        out.writeObject(new PersonA("Mike", 45, new Address("Mazurova")));
        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);
        System.out.println(Arrays.toString(rawData));
        System.out.println(new String(rawData, "utf8"));

        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(rawData));
        System.out.println(in.readObject());

    }
}
