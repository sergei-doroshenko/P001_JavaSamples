package org.sergei._0_core._6_oop._1_virtual;

import java.lang.reflect.Field;

/**
 * Created by Sergei on 18.03.2015.
 */
public class App06_template_method {
    public static void main(String[] args) {
        System.out.println(new Test01(10, 20));
        System.out.println(new ChildTest01(15, 25, 35));
    }
}

class Test01 extends ToStr {
    int x;
    int y;

    public Test01(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ChildTest01 extends Test01 {
    int z;

    public ChildTest01(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class ToStr {
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields(); // all the fields declared by the class represented by this
        //Field[] fields = clazz.getFields(); // all the accessible public fields of the class represented by this

        result.append(clazz.getSimpleName());
        result.append("{");
        Class superclass = clazz.getSuperclass();

        while (superclass != null) {
            Field[] superFields = superclass.getDeclaredFields();
            if (superFields.length > 0) {
                appendFields(result, superFields);
            }
            clazz = superclass;
            superclass = clazz.getSuperclass();
        }

        appendFields(result, fields);
        //result.setCharAt(result.length()-1, '\u0000');
        result.replace(result.length()-2, result.length(), "");
        result.append("}");
        return result.toString();
    }

    private StringBuilder appendFields(StringBuilder result, Field[] fields) {

        for (Field field : fields) {
            try {
                result
                        .append(field.getName())
                        .append("=")
                        .append(field.get(this))
                        .append(", ");
            } catch (IllegalAccessException e) {
                throw new Error();
            }
        }

        return result;
    }
}
