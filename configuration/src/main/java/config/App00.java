package config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Sergei on 20.08.2015.
 */
public class App00 {

    public static void main(String[] args) {
        try {
            XMLConfiguration configuration = new XMLConfiguration("config.xml");
            Iterator<String> iterator = configuration.getKeys();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println(Arrays.toString(configuration.getStringArray("nestedproperty.arrayvalue")));
            System.out.println(configuration.getString("nestedproperty.property"));

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }


}
