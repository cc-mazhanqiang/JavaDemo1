package cnn.whoops.netTest;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: whoops
 * @date: 2021/8/2 - 20:14
 * @description:
 */
public class TcpTest {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1", 10000);

            os = socket.getOutputStream();
            os.write("来自客户端的请求！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream socketInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(10000);

            socket = serverSocket.accept();

            socketInputStream = socket.getInputStream();

            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] bytes = new byte[20];
            int len;
            while ((len = socketInputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,len);
            }

            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自客户端:" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null)
                    byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socketInputStream != null)
                    socketInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
