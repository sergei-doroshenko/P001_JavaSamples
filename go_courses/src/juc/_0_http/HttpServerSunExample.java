package juc._0_http;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.net.httpserver.DefaultHttpServerProvider;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by Sergei on 27.03.2015.
 */
public class HttpServerSunExample {
    public static void main(String[] args) throws IOException {
        HttpServerProvider provider = DefaultHttpServerProvider.provider();
        final HttpServer server = provider.createHttpServer(new InetSocketAddress(84), 64);
        server.setExecutor(Executors.newCachedThreadPool());

        HttpContext baseContext = server.createContext("/");
        baseContext.setHandler(new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String protocol = httpExchange.getProtocol();
                String requestMethod = httpExchange.getRequestMethod();
                URI requestURI = httpExchange.getRequestURI();
                Headers requestHeaders = httpExchange.getRequestHeaders();

                String htmlPage = createResponsePage(protocol, requestMethod, requestURI, requestHeaders);

                Headers responseHeaders = httpExchange.getResponseHeaders();
                responseHeaders.add("X-MyHeader", "1");
                responseHeaders.add("X-MyHeader", "2");
                responseHeaders.add("X-MyHeader", "3");
                httpExchange.sendResponseHeaders(200, htmlPage.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(htmlPage.getBytes(StandardCharsets.US_ASCII));
                os.close();
            }


        });
        server.start();
    }

    private static String createResponsePage(String protocol, String requestMethod,
                                             URI requestURI, Headers requestHeaders) {

        StringBuilder sb = new StringBuilder("<html><body>");
        sb.append("<div>Protocol: " + protocol + "</div>");
        sb.append("<div>Method: " + requestMethod + "</div>");
        sb.append("<div>URI: " + requestURI + "</div>");
        for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
            sb.append("<div>" + header.getKey() + ": ");
            for (String val : header.getValue()) {
                sb.append(val + ", ");
            }
            sb.delete(sb.length()-2, sb.length()); // delete 2 last chars "," and " "
            sb.append("</div>");
        }

        return sb.append("</body></html>").toString();
    }
}
