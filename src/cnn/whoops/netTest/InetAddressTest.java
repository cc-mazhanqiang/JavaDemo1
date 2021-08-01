package cnn.whoops.netTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: whoops
 * @date: 2021/8/1 - 22:33
 * @description:
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
