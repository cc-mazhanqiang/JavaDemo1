package cnn.whoops.netTest;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: whoops
 * @date: 2021/8/2 - 21:06
 * @description:
 *
 * 客户端发送文件给服务端，并保存在本地之后，返回"发送成功"给客户端.
 *
 */
public class TcpTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
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
            //关闭数据的输出
            socket.shutdownOutput();

            //接收服务端发送的反馈信息
            is = socket.getInputStream();
            //防止出现中文乱码
            baos = new ByteArrayOutputStream();
            byte[] bt = new byte[20];
            int sen;
            while ((sen = is.read(bt)) != -1){
                baos.write(bt,0,sen);
            }
            //打印输出
            System.out.println(baos.toString());

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
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                    baos.close();
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
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();

            //读取来自客户端传来的数据
            is = socket.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream("232.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }

            System.out.println("server");

            //服务端将反馈信息给客户端
            os = socket.getOutputStream();
            os.write("保存成功".getBytes());

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
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
