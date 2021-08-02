package cnn.whoops.netTest;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: whoops
 * @date: 2021/8/2 - 20:46
 * @description:
 *
 * 服务端将客户端发送过来的文件保存在本地
 *
 */
public class TcpTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            //1、创建socket对象
            socket = new Socket("127.0.0.1", 9000);

            //2、创建socket输入流对象,传到服务端
            os = socket.getOutputStream();

            //3、创建缓冲流对象提高效率，读取文件
            bis = new BufferedInputStream(new FileInputStream("23.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os !=  null)
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
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();

            //读取来自客户端传来的数据
            is = socket.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream("231.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
            System.out.println("保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
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
