package core._11_memory_overflow;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Sergei on 05.10.2015.
 */
public class App04_permget_overflow {
    public static void main(String[] args) {
        for(;;) {
            InvocationHandler handler = new MyInvocationHandler();
            MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                    MyInterface.class.getClassLoader(),
                    new Class[]{MyInterface.class},
                    handler);
        }

    }
}

interface MyInterface {

}

class MyInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}