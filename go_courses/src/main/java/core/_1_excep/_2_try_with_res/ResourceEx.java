package core._1_excep._2_try_with_res;

/**
 * Created by Sergei on 26.02.2015.
 */
public class ResourceEx implements AutoCloseable {
    private String name;

    public ResourceEx(String name) {
        this.name = name;
        System.err.println("new: " + name);
    }

    @Override
    public void close() throws Exception {
        System.err.println("auto-close: " + name);
        throw new RuntimeException(name);
    }
}
