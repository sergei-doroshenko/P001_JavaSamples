package org.sergei._0_core._3_io._3_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {

        try (ServerSocket serverSocket = createServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Connection successful");
            System.out.println("Waiting for input.....");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

    }

    private ServerSocket createServerSocket(int port) throws IOException {
        InetSocketAddress address = new InetSocketAddress(port);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
        serverSocket.setSoTimeout(3000);
        serverSocket.bind(address);
        return serverSocket;
    }
}
