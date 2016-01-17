package _12_Localization;

import java.util.ListResourceBundle;

// Italian version
public class _12_4_ResBundle_it_IT extends ListResourceBundle {
	public Object[][] getContents() {
        		return contents;
    	}

	static final Object[][] contents = {
		{ "MovieName", "Che Bella Giornata" },
		{ "GrossRevenue", 43000000L}, // in euros
		{ "Year", 2011}
	};
}
