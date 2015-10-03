package creational.abstract_factory;

/**
 * Created by Sergei on 14.08.2015.
 */
public class PDFDocumentFactory implements AbstractDocumentFactory {
    @Override
    public AbstractLetter createLetter() {
        return new PDFLetter();
    }

    @Override
    public AbstractResume createResume() {
        return new PDFResume();
    }
}
