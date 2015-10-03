package creational.prototype;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Book extends Product {
    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
