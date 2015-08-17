package creational.prototype;

/**
 * Created by Sergei on 17.08.2015.
 */
public class App00 {
    public static void main(String[] args) {
        ProductCache.loadCache();

        Book clonedBook = (Book) ProductCache.getProduct("B1");
        System.out.println(clonedBook);

        DVD clonedDVD = (DVD) ProductCache.getProduct("D1");
        System.out.println(clonedDVD);
    }
}
