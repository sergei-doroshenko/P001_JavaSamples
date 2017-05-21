package org.sergei._1_advanced._1_concurrent.serial_executor._0_http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Sergei on 27.03.2015.
 */
public class HttpHandler implements Callable<String> {
    private final Socket socket;

    public HttpHandler(Socket soket) {
        this.socket = soket;
    }

    @Override
    public String call() throws Exception {
        String result = null;
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            // READ request
            byte[] request = HttpUtils.readRequestFully(in);
            result = new String(request, HttpUtils.US_ASCII);
            System.out.println("----------------------------------");
            System.out.print(result);
            System.out.println("---------------------------------");

            // WRITE response
            byte[] response = HttpUtils.createResponse(new Date().toString());
            out.write(response);
        } finally {
            socket.close();
        }

        return result;
    }
}
