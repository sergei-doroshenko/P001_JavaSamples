package behavioral.template_method.exporter;

/**
 * Created by Sergei on 10.09.2015.
 */
public class PdfDataExporter extends DataExporter {
    @Override
    public void formatData() {
        System.out.println("format in PDF...");
    }
}
