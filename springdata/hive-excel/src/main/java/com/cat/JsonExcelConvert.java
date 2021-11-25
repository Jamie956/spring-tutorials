package com.cat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class JsonExcelConvert {
    /**
     * json array 转 excel
     * @param jsonArray json array 数据
     * @param destPath 存储路径
     * @param headers 按指定名字和顺序生成 excel 头部
     */
    public static void json2Excel(JSONArray jsonArray, String destPath, String[] headers) throws IOException {
        if (jsonArray.size() == 0) {
            return;
        }
        try (FileOutputStream out = new FileOutputStream(new File(destPath));
             XSSFWorkbook wb = new XSSFWorkbook();
        ) {
            int rowNum = 0;
            int column = 0;
            List<JSONObject> list = jsonArray.toJavaList(JSONObject.class);

            Sheet sheet = wb.createSheet("sheet0");
            Row row = sheet.createRow(rowNum++);
            //标题
            String[] keys = headers == null ? list.get(0).keySet().toArray(new String[]{}) : headers;
            for (String key : keys) {
                row.createCell(column++).setCellValue(key);
            }
            //每行json值 转excel 行
            column = 0;
            for (JSONObject json : list) {
                row = sheet.createRow(rowNum++);
                for (String key : keys) {
                    row.createCell(column++).setCellValue(json.getString(key));
                }
                column = 0;
            }
            wb.write(out);
        }
    }

    public static void json2Excel(JSONArray jsonArray, String destPath) throws IOException {
        json2Excel(jsonArray, destPath, null);
    }

    /**
     * excel文件 转成json 文件
     */
    public static void excel2json(String srcPath, String destPath) throws Exception {
        try (InputStream inputStream = new FileInputStream(srcPath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
             FileWriter fileWriter = new FileWriter(destPath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                JSONObject json = excelRowToJson(firstRow, row);
                bufferedWriter.write(json.toJSONString() + "\r\n");
            }
            bufferedWriter.flush();
        }
    }

    /**
     * 将excel 的一行数据转成json
     */
    private static JSONObject excelRowToJson(Row headers, Row row) {
        JSONObject json = new JSONObject();

        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            String header = headers.getCell(i).getStringCellValue();
            if (cell != null) {
                CellType cellType = cell.getCellType();
                if (cellType.equals(CellType.NUMERIC)) {
                    json.put(header, cell.getNumericCellValue());
                }
                if (cellType.equals(CellType.STRING)) {
                    json.put(header, cell.getRichStringCellValue().toString());
                }
            }
        }
        return json;
    }

}
