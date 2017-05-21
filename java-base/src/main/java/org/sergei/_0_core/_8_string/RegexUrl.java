package org.sergei._0_core._8_string;

import java.util.List;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

/**
 * Created by Sergei_Doroshenko on 1/19/2017.
 */
public class RegexUrl {
    public static final String NEW_URL_DOMAIN_REGEX = "(?i)^(http(s)?://)?(www.)?(([\\da-z_.-]+)\\.([a-z.]{2,6}))(:\\d+)?([^?#]*)?(.*)*/?$";
    public static final String REGEX2 = "^((http(s)?://)|(www.))(([\\da-z_\\.-]+)\\.([a-z\\.]{2,6}))(:\\d+)?([^\\?#]*)?(.*)*\\/?$";
    public static Pattern pattern = Pattern.compile(REGEX2);

    public static boolean isUrl(String url) {
        return pattern.matcher(url.trim()).matches();
    }

    public static void main(String[] args) {
        List<String> urls = Lists.newArrayList(
                "hello.people",
                "hello people",
                "https://leningrad-spb.ru/workfusion",
                "http://leningrad-spb.ru/workfusion",
                "www.leningrad-spb.ru"
        );

        urls.stream().forEach(u -> System.out.println(u + ": " + isUrl(u)));
    }
}
