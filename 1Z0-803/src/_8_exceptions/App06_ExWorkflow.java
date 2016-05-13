package _8_exceptions;

/**
 * Created by Sergei_Doroshenko on 5/11/2016.
 */
public class App06_ExWorkflow {
    public static void main(String[] args) {
        System.out.println("Before try.");
        try {
            System.out.println("try...");
            throw new RuntimeException("Test exception.");
        } catch (RuntimeException /*IllegalStateException*/ e) {
            System.out.println("catch..." + e.getMessage());

        } finally {
            System.out.println("finally...");
        }

        System.out.println("After finally...");
    }
}
/*

Before try.
try...
catch...Test exception.
finally...
After finally...

or

Before try.
Exception in thread "main" java.lang.RuntimeException: Test exception.
try...
	at _8_exceptions.App06_ExWorkflow.main(App06_ExWorkflow.java:11)
finally...
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

*/