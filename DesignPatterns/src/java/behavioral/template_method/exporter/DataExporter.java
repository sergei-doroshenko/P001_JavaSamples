package behavioral.template_method.exporter;

/**
 * Created by Sergei on 10.09.2015.
 */
public abstract class DataExporter {
    public final void export() {
        readData();
        formatData(); // overrides in descendants
        exportData();
    }

    private final void readData() {
        System.out.println("read data...");
    }

    protected abstract void formatData();

    private final void exportData() {
        System.out.println("export data...");
    }

}
