package structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei on 26.08.2015.
 */
public class RealSubject implements Subject {
    private Map<String, String> storage = new HashMap<>();

    public RealSubject() {
        storage.put("name", "Ivan");
        storage.put("age", "32");
        storage.put("sex", "mail");
    }

    @Override
    public String get(String key) {
        return storage.get(key);
    }
}
