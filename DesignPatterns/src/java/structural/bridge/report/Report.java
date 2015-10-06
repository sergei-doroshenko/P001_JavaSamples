package structural.bridge.report;

import structural.bridge.format.Format;

/**
 * Created by Sergei on 06.09.2015.
 * !!! IMPORTANT !!!
 * Children of Report call only parent' methods not Format or it' descendants
 * So we have bridge Report - Format
 */
public abstract class Report {
    private Format format = Format.getInstance(Format.Type.XML);

    public void setFormat(Format.Type type) {
        format = Format.getInstance(type);
    }

    protected String formatHead(String source) {
        return format.formatHead(source);
    }

    protected String formatBody(String source) {
        return format.formatBody(source);
    }

    protected String formatFooter(String source) {
        return format.formatFooter(source);
    }

    public abstract String createReportHead();

    public abstract String createReportBody();

    public abstract String createReportFooter();

    public abstract String formatReportHead(String source);

    public abstract String formatReportBody(String source);

    public abstract String formatReportFooter(String source);
}
