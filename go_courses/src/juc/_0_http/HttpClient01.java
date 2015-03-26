package juc._0_http;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Sergei on 26.03.2015.
 */
public class HttpClient01 {

    public static void main(String[] args) throws Exception {

        HttpClient01 http = new HttpClient01();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        Socket socket = new Socket(InetAddress.getByAddress(new byte[]{127, 0, 0, 2}), 8183);

        try (InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream() ) {

            // WRITE request
            out.write(new String("GET / HTTP/1.1\r\n").getBytes());
            out.write(new String("Host: 127.0.0.2:8183\r\n").getBytes());
            out.write(new String("Connection: keep-alive\r\n").getBytes());
            out.write(new String("User-Agent: Mozilla/5.0\r\n").getBytes());
            out.write(HttpUtils.HEADER_END);
            out.flush();

            // READ response
            StringBuilder sb = new StringBuilder();
            byte[] buff = new byte[16];
            int len = 0;
            int count;
            while ( (count = in.read(buff, len, buff.length - len)) != -1 ) {
                if (count < 0) {
                    throw new RuntimeException("Incoming connection closed.");
                } else {
                    len += count;
                    if (len == buff.length || HttpUtils.isMessageEnd(buff, len)) {
                        System.out.println("flush");
                        sb.append(new String(buff, HttpUtils.US_ASCII));
                        len = 0;
                    }
                }

            }
            System.out.println(sb);
        } finally {
            socket.close();
        }


        /*String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());*/

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        //todo: implement this method

    }
}
