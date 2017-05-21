package org.sergei.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDate {
    public static void main(String[] args) throws IOException {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        String dateString01 = "2017-03-19T24:00:00";
        String dateString02 = "\"2017-05-19T24:00:00\"";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Date gsonDate = gson.fromJson(dateString02, Date.class);
        System.out.println(gsonDate);

        ObjectMapper objectMapper = new ObjectMapper();
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        objectMapper.setDateFormat(df);
        Date jacksonDate = objectMapper.readValue(dateString02, Date.class);
        System.out.println(jacksonDate);
    }

}
