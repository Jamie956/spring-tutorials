package com.cat;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DownloadController {

    /**
     * http://localhost:8844/dd
     * spring http 下载
     */
    @GetMapping("/dd")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadFile() throws FileNotFoundException, InterruptedException {
        String fileName = "README.txt";
        File file = new File("src/main/resources/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s", fileName));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
        String headersStr = responseEntity.getHeaders().toString();
        System.out.println(headersStr);
        return responseEntity;
    }

    /**
     * servlet 输出流将文件传递到浏览器
     * http://localhost:8844/d1
     * <p>
     * Response Header:
     * ContentType             application/txt?不存在这类型
     * Content-Disposition     attachment;filename=README.txt
     * Transfer-Encoding       chunked
     * Date                    Thu, 04 Nov 2021 10:13:45 GMT
     */
    @GetMapping("/d1")
    public void downloadByServletStream(HttpServletResponse response) throws UnsupportedEncodingException {
        String fileName = "README.txt";
        Path path = Paths.get("src/main/resources", fileName);
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        response.setContentType("application/" + fileSuffix);
        // 对fileName重新编码，http头信息只识别 ISO8859-1
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1"));

        try {
            Files.copy(path, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * servlet 输出流将文件传递到浏览器
     * http://localhost:8844/d2
     * <p>
     * Response Header:
     * ContentType             application/txt?不存在这类型
     * Content-Disposition     attachment;filename=README.txt
     * Transfer-Encoding       chunked
     * Date                    Thu, 04 Nov 2021 10:13:45 GMT
     */
    @GetMapping("/d2")
    public void downloadByServletStream2(HttpServletResponse response) throws UnsupportedEncodingException {
        String fileName = "README.txt";
        File file = new File("src/main/resources/" + fileName);
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        response.setContentType("application/" + fileSuffix);
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1"));

        try (FileInputStream inputStream = new FileInputStream(file); ServletOutputStream outputStream = response.getOutputStream()) {
            int readLength;
            byte[] buffer = new byte[1024];
            while (true) {
                readLength = inputStream.read(buffer);
                if (readLength == -1) {
                    break;
                } else {
                    outputStream.write(buffer, 0, readLength);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * servlet 输出流将文件传递到浏览器
     * http://localhost:8844/d3
     * <p>
     * 把数据全部加载到内存
     * byte[] buffer = new byte[fis.available()];
     * <p>
     * Response Header:
     * Content-Disposition      attachment;filename=README.txt
     * Content-Type             application/octet-stream;charset=UTF-8
     * Content-Length           1052389
     * Date                     Thu, 04 Nov 2021 10:13:45 GMT
     * <p>
     * Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
     * attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
     * filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
     */
    @GetMapping("/d3")
    public void download(HttpServletResponse response) {
        try {
            //文件输入流
            String fileName = "README.txt";
            File file = new File("src/main/resources/" + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);

            //设置header
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");

            //数据放到内存缓冲区，写到 response 输出流
            byte[] buffer = new byte[fis.available()];
            int read = fis.read(buffer);
            fis.close();
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(buffer);
            outputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 将输入流中的数据循环写入到响应输出流中，而不是一次性读取到内存
     * 从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
     * http://localhost:8844/d4
     * <p>
     * Response Header:
     * ContentType             application/octet-stream
     * Content-Disposition     attachment;filename=README.txt
     * Transfer-Encoding       chunked
     * Date                    Thu, 04 Nov 2021 10:13:45 GMT
     */
    @RequestMapping("/d4")
    public void downloadLocal(HttpServletResponse response) throws IOException {
        //文件输入流
        String fileName = "README.txt";
        File file = new File("src/main/resources/" + fileName);
        InputStream inputStream = new FileInputStream(file);

        //设置header
        response.reset();
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        //数据放到内存缓冲区，写到 response 输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        //从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
        while ((len = inputStream.read(b)) > 0) {
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }

    /**
     * 网络文件下载
     * attachment 下载文件；inline 在线浏览
     * http://localhost:8844/d5
     */
    @RequestMapping("/d5")
    public void downloadNet(HttpServletResponse response) throws IOException {
        //网络文件输入流
        String netAddress = "http://news.baidu.com/";
        URL url = new URL(netAddress);
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();

        //设置header
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("baidu.html", "UTF-8"));

        //数据放到内存缓冲区，写到 response 输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, readLength);
        }
    }

}
