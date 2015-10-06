package behavioral.template_method;

import behavioral.template_method.exporter.DataExporter;
import behavioral.template_method.exporter.ExcelDataExporter;
import behavioral.template_method.exporter.PdfDataExporter;

/**
 * Created by Sergei on 10.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        DataExporter excelExporter = new ExcelDataExporter();
        excelExporter.export();

        DataExporter pdfExporter = new PdfDataExporter();
        pdfExporter.export();
    }
}
