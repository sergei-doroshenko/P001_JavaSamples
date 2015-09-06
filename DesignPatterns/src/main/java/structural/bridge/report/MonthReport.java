package structural.bridge.report;

/**
 * Created by Sergei on 06.09.2015.
 */
public class MonthReport extends Report {

    @Override
    public String createReportHead() {
        return "Report: 2015 October month.";
    }

    @Override
    public String createReportBody() {
        return "Body of 2015 October month.";
    }

    @Override
    public String createReportFooter() {
        return "Total 2015 October month.";
    }

    // !!! IMPORTANT !!!
    // Children call only parent' methods not Format or it' descendants
    @Override
    public String formatReportHead(String source) {
        return super.formatHead(source);
    }

    @Override
    public String formatReportBody(String source) {
        return super.formatBody(source);
    }

    @Override
    public String formatReportFooter(String source) {
        return super.formatFooter(source);
    }
}
