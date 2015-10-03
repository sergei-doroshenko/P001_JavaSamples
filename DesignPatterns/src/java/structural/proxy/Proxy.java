package structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei on 26.08.2015.
 */
public class Proxy implements Subject {
    private Subject realSubject = new RealSubject();
    private Map<String, String> cache = new HashMap<>();

    @Override
    public String get(String key) {
        if (cache.get(key) == null) {
            System.out.println("Call realSubject");
            cache.put(key, realSubject.get(key));
        }
        return cache.get(key);
    }
}
