package org.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class DownloadTest {

    /**
     * ResponseEntity set bytes to implement download
     * http request test:
     *      method: get
     *      url: http://localhost:8080/home/testDown
     */
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        //D:\dev\project\spring-tutorials\spring-mvc-learn\demo3\target\demo3-1.0-SNAPSHOT\1.txt
        String realPath = servletContext.getRealPath("/1.txt");
        InputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.txt");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        is.close();
        return responseEntity;
    }
}
