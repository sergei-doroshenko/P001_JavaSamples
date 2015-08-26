package structural.proxy;

/**
 * Created by Sergei on 26.08.2015.
 */
public class Clien {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        System.out.println(subject.get("name"));
        System.out.println(subject.get("sex"));
        System.out.println(subject.get("name"));
        System.out.println(subject.get("age"));
        System.out.println(subject.get("name"));
        System.out.println(subject.get("age"));
    }
}
