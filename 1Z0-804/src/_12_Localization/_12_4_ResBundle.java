package _12_Localization;

import java.util.ListResourceBundle;

// default US English version
public class _12_4_ResBundle extends ListResourceBundle {
	public Object[][] getContents() {
        		return contents;
    	}

	static final Object[][] contents = {
		{ "MovieName", "Avatar" },
		{ "GrossRevenue", 2782275172L}, // in US dollars
		{ "Year", 2009}
	};
}
