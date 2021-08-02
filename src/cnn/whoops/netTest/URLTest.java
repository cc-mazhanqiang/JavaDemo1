package cnn.whoops.netTest;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: whoops
 * @date: 2021/8/2 - 22:37
 * @description:
 */
public class URLTest {
    @Test
    public void URLtest() {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        BufferedOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/7.JPG");
            urlConnection = (HttpURLConnection) url.openConnection();
            //获取连接
            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new BufferedOutputStream(new FileOutputStream("233.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

            System.out.println("下载完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null)
                urlConnection.disconnect();
        }


    }
}
