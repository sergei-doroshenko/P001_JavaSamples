package _03_ClassDesign;

/**
 * Created by Sergei on 31.05.2015.
 */
public class App00_instanceOf {
    public static void main(String[] args) {
        String str = "hello";
        Object obj = str;

        System.out.println(obj instanceof String);
        obj = null;
        System.out.println(obj instanceof String);
        System.out.println(null instanceof String);
        Class clazz = null;
        System.out.println(obj instanceof java.lang.Number);
    }
}
