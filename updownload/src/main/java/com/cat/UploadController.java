package com.cat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@RestController
public class UploadController {
    /*
    PostMan测试
    Method: POST
    URL: localhost:8080/upload
    key:file, type:file, value: select file
     */
    @PostMapping("upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile, HttpServletRequest request) {
        try {
            //创建文件夹
            String targetPath = request.getContextPath() + "upload";
            File folder = new File(targetPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            //获取文件名
            String filename = uploadfile.getOriginalFilename();
            //完整路径
            File targetFilePath = new File(Paths.get(targetPath, filename).toString());

            //input
            byte[] uploadfileBytes = uploadfile.getBytes();

            //output
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(targetFilePath));
            stream.write(uploadfileBytes);
            stream.close();

			System.out.println("upload file: " + targetFilePath);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
