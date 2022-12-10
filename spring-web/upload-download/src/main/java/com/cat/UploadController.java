package com.cat;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 上传excel 输入流 -> workbook
     */
    @PostMapping("u3")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<String> headers = new ArrayList<>();
            for (Row row : sheet) {
                if (headers.isEmpty()) {
                    for (Cell cell : row) {
                        String header = cell.getStringCellValue();
                        if (StringUtils.isNotBlank(header)) {
                            if (headers.contains(header)) {
                                throw new RuntimeException("存在重复表头");
                            }
                            headers.add(header);
                        }
                    }
                    continue;
                }
                JSONObject json = new JSONObject();
                for (int i = 0; i < headers.size(); i++) {
                    String key = headers.get(i);
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        CellType cellType = cell.getCellType();
                        if (cellType.equals(CellType.NUMERIC)) {
                            json.put(key, cell.getNumericCellValue());
                        }
                        if (cellType.equals(CellType.STRING)) {
                            json.put(key, cell.getRichStringCellValue().toString());
                        }
                    }
                }
                System.out.println(json.toJSONString());
            }
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
