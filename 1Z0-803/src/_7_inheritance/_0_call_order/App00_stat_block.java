package _7_inheritance._0_call_order;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App00_stat_block {
    // This code doesn't compile, because Initializer must able to complete normally.
    /*static {
        throw new RuntimeException();
    }*/
    // But this one compile perfectly, but when run throw ExceptionInInitializerError caused by RuntimeException.
    // The full stack trace listened below.
    static {
        if (true) throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
    // So the string "Hello" will never prints.
}

/*
Exception in thread "main" java.lang.ExceptionInInitializerError
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:190)
        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:116)
        Caused by: java.lang.RuntimeException
        at _7_inheritance._0_call_order.App00_stat_block.<clinit>(App00_stat_block.java:13)
        ... 3 more
        */
