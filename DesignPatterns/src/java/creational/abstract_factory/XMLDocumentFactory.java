package creational.abstract_factory;

/**
 * Created by Sergei on 14.08.2015.
 */
public class XMLDocumentFactory implements AbstractDocumentFactory {
    @Override
    public AbstractLetter createLetter() {
        return new XMLLetter();
    }

    @Override
    public AbstractResume createResume() {
        return new XMLResume();
    }
}
