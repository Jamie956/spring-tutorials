package com.cat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author zjm
 */
@RestController
public class UploadController {
    /**
     * 上传文件输入流 -> 文件缓存输出流
     * curl --location --request POST 'localhost:8844/u1' \
     * --header 'Content-Type: multipart/form-data' \
     * --form 'file=@"/C:/Users/tgwzz/Desktop/tu.xlsx"'
     */
    @PostMapping("u1")
    public ResponseEntity<?> uploadStoreAsFile(@RequestParam("file") MultipartFile file) {
        String storePath = "src/main/resources/";
        //获取文件名
        String fileName = file.getOriginalFilename();
        File storeFile = new File(storePath + fileName);

        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(storeFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            //创建文件夹
            if (!storeFile.exists()) {
                boolean createStoreDirSuccess = storeFile.mkdirs();
                if (!createStoreDirSuccess) {
                    throw new RuntimeException("创建文件夹失败");
                }
            }

            byte[] buffer = new byte[1024];
            int readLength;
            while (true) {
                readLength = bufferedInputStream.read(buffer);
                if (readLength != -1) {
                    bufferedOutputStream.write(buffer, 0, readLength);
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 上传文件输入流 -> 内存数组输出流
     */
    @PostMapping("u2")
    public ResponseEntity<?> uploadAsStream(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            byte[] buffer = new byte[1024];
            int readLength;

            while (true) {
                readLength = bufferedInputStream.read(buffer);
                if (readLength != -1) {
                    byteArrayOutputStream.write(buffer, 0, readLength);
                } else {
                    break;
                }
            }

            String s = byteArrayOutputStream.toString();
            System.out.println(s);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
