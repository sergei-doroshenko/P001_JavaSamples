package core._3_io._2_serialization;

import java.io.Serializable;

/**
 * Created by Sergei on 10.03.2015.
 */
public class Address implements Serializable {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                '}';
    }
}
