package core._11_memory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Sergei on 05.10.2015.
 */
public class App04_dynamic_proxy {
    public static void main(String[] args) {
        List<MyInterface> list = new ArrayList<>();
        InvocationHandler handler = new MyInvocationHandler();

        for(;;) {
            MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                    MyInterface.class.getClassLoader(),
                    new Class[]{MyInterface.class},
                    handler);

            list.add(proxy);
            proxy.print(list.size());
        }

    }
}

interface MyInterface {
    void print(int i);
}

class MyInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Arrays.toString(args));
        return null;
    }
}