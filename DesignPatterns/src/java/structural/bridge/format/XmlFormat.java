package structural.bridge.format;

/**
 * Created by Sergei on 06.09.2015.
 */
public class XmlFormat extends Format {
    private String formatString = "XML";

    @Override
    public String formatHead(String source) {
        return source + " Head in " + formatString + "\n";
    }

    @Override
    public String formatBody(String source) {
        return source + " Body in " + formatString + "\n";
    }

    @Override
    public String formatFooter(String source) {
        return source + " Footer in " + formatString + "\n";
    }
}
