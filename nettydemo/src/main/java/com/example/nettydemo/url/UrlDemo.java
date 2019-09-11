package com.example.nettydemo.url;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname UrlDemo
 * @Description TODO
 * @Date 2019/9/3 15:27
 * @Author lyn
 */
public class UrlDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com/");
        URLConnection connection = url.openConnection();
        try (InputStream in = connection.getInputStream()){

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int len = -1;

            while ((len = in.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }

            System.out.println(new String(outputStream.toByteArray()));


            System.out.println("host: " + url.getHost());
            System.out.println("port: " + url.getPort());
            System.out.println("uri_path: " + url.getPath());

            /*
            返回 Content-type 头字段的值，即数据的 MIME 内容类型。若类型不可用，则返回 null。如果内容类型是文本，
            则 Content-type 首部可能会包含一个标识内容编码方式的字符集，例如：Content-type:text/html; charset=UTF-8
             */
            System.out.println(connection.getContentType());
            //返回 Content-length 头字段的值，即内容的字节数
            System.out.println(connection.getContentLength());
            //返回 Content-encoding 头字段的值，即内容的编码方式（不同于字符编码方式），例如：x-gzip。
            System.out.println(connection.getContentEncoding());
            //返回 date 头字段的值，即请求的发送时间。
            System.out.println(connection.getDate());
            //返回 expires（过期时间） 头字段的值。如果返回 0，表示不过期，永远缓存。
            System.out.println(connection.getExpiration());
            //返回 last-modified（上次修改日期） 头字段的值。
            System.out.println(connection.getLastModified());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
