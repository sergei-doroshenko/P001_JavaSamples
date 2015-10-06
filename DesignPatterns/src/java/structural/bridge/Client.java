package structural.bridge;

import structural.bridge.format.Format;
import structural.bridge.report.Report;
import structural.bridge.report.YearReport;

/**
 * Created by Sergei on 06.09.2015.
 */
public class Client {
    public static void main(String[] args) {
        Report yearReport = new YearReport();
        String yearHead = yearReport.createReportHead();
        String yearBody = yearReport.createReportBody();
        String yearFooter = yearReport.createReportFooter();

        String yearHeadFormatted = yearReport.formatReportHead(yearHead);
        String yearBodyFormatted = yearReport.formatReportBody(yearBody);
        String yearFooterFormatted = yearReport.formatReportFooter(yearFooter);

        System.out.println(yearHeadFormatted + " " + yearBodyFormatted + " " + yearFooterFormatted);

        Report monthReport = new YearReport();
        String monthHead = monthReport.createReportHead();
        String monthBody = monthReport.createReportBody();
        String monthFooter = monthReport.createReportFooter();

        monthReport.setFormat(Format.Type.PDF);

        String monthHeadFormatted = monthReport.formatReportHead(monthHead);
        String monthBodyFormatted = monthReport.formatReportBody(monthBody);
        String monthFooterFormatted = monthReport.formatReportFooter(monthFooter);

        System.out.println(monthHeadFormatted + " " + monthBodyFormatted + " " + monthFooterFormatted);
    }
}
