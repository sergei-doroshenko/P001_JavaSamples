package structural.bridge.format;

/**
 * Created by Sergei on 06.09.2015.
 */
public abstract class Format {
    public enum Type {
        XML, PDF, HTML
    }

    public static Format getInstance(Type type) {
        switch (type) {
            case XML: return new XmlFormat();
            case PDF: return new PdfFormat();
            case HTML: return new HtmlFromat();
            default: return new XmlFormat();
        }
    }

    public abstract String formatHead (String source);

    public abstract String formatBody (String source);

    public abstract String formatFooter (String source);
}
