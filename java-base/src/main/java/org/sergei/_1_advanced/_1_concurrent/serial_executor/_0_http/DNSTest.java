package org.sergei._1_advanced._1_concurrent.serial_executor._0_http;

import sun.net.spi.nameservice.NameService;
import sun.net.spi.nameservice.dns.DNSNameService;

import java.net.InetAddress;

/**
 * Created by Sergei on 25.03.2015.
 */
public class DNSTest {
    public static void main(String[] args) throws Exception {
        NameService dns = new DNSNameService();
        InetAddress[] addresses = dns.lookupAllHostAddr("www.abcdegf.com");

        for (InetAddress address : addresses) {
            System.out.println(address);
            System.out.println("  " + dns.getHostByAddr(address.getAddress()));
        }
    }
}
