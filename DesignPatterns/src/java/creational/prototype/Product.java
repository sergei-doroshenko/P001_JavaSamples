package creational.prototype;

/**
 * Created by Sergei on 17.08.2015.
 */
public abstract class Product implements Cloneable {
    private String SKU;
    private String description;

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SKU=" + SKU + ", description=" + description;
    }
}
