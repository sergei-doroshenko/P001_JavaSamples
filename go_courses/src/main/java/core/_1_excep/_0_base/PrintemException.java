package core._1_excep._0_base;

/**
 * Created by Sergei on 26.02.2015.
 */
public class PrintemException extends Exception {
    private int errorCodeA;
    private int errorCodeB;
    private String document;

    public PrintemException(int errorCodeA, int errorCodeB, String document) {
        this.errorCodeA = errorCodeA;
        this.errorCodeB = errorCodeB;
        this.document = document;
    }

    public int getErrorCodeA() {
        return errorCodeA;
    }

    public int getErrorCodeB() {
        return errorCodeB;
    }

    public String getDocument() {
        return document;
    }
}
