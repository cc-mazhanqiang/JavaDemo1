package cnn.whoops.netTest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author: whoops
 * @date: 2021/8/2 - 21:48
 * @description:
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = new String("UDP发送的数据！");
        byte[] bytes = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,localHost,9000);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void recevier() throws IOException {
        DatagramSocket socket = new DatagramSocket(9000);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
