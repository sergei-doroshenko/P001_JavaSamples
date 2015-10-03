package creational.abstract_factory;

/**
 * Created by Sergei on 14.08.2015.
 */
public class App {
    public static void main(String[] args) {
        AbstractDocumentFactory factory;

        factory = new PDFDocumentFactory();
        AbstractLetter letter0 = factory.createLetter();
        AbstractResume resume0 = factory.createResume();

        System.out.printf("Factory created: letter %s and resume %s\n", letter0.getClass().getSimpleName(), resume0.getClass().getSimpleName());

        factory = new XMLDocumentFactory();

        AbstractLetter letter1 = factory.createLetter();
        AbstractResume resume1 = factory.createResume();

        System.out.printf("Factory created: letter %s and resume %s\n", letter1.getClass().getSimpleName(), resume1.getClass().getSimpleName());
    }
}
