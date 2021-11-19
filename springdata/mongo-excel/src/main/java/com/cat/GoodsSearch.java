package com.cat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsSearch {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findById() {
        TmallComment u = mongoTemplate.findById("5fe5bbf46854cab1eef84b5a", TmallComment.class);
        System.out.println("u => " + u);
    }

    /**
     * 天猫查询 location=广东，goods_name=关键字，rateDate=20年
     * <p>
     * 按商品=title 聚合
     */
    public void tmCommentExportToExcel(String keyword) throws IOException {
        Query query = Query.query(Criteria.where("rateDate").gte("2020-01-01 00:00:00").lt("2021-01-01 00:00:00")
                .and("goods_name").regex(keyword).and("location").regex("广东"));

        long count = mongoTemplate.count(query, TmallComment.class);
        System.out.println(String.format("关键字[%s] 查出 [%s] 条", keyword, count) );
        List<TmallComment> items = mongoTemplate.find(query.limit((int) count), TmallComment.class);

        Map<String, List<TmallComment>> maps = items.stream().collect(Collectors.groupingBy(TmallComment::getTitle));
        JSONArray jsonArray = new JSONArray();
        maps.forEach((key, value) -> {
            //同一家店铺只取第一条
            TmallComment firstTmallCommentInGroup = value.get(0);
            firstTmallCommentInGroup.setCommentSum(value.size());
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(firstTmallCommentInGroup));
            jsonArray.add(jsonObject);
        });
        System.out.println("开始写入excel");
        JsonExcelConvert.json2Excel(jsonArray, "D:\\天猫导出数据-"+keyword+".xlsx");
    }

    /**
     * 燃气
     * 文件夹
     * 文件架
     * 订书机
     * 修正笔
     * 修正带
     * 橡皮
     * 修正液
     * 笔
     * 文具
     * 电动自行车
     */
    @Test
    public void tmCommentExportToExcelTest() throws IOException {
        tmCommentExportToExcel("燃气");
        tmCommentExportToExcel("文件夹");
        tmCommentExportToExcel("文件架");
        tmCommentExportToExcel("订书机");
        tmCommentExportToExcel("修正笔");
        tmCommentExportToExcel("修正带");
        tmCommentExportToExcel("橡皮");
        tmCommentExportToExcel("修正液");
        tmCommentExportToExcel("笔");
        tmCommentExportToExcel("文具");
        tmCommentExportToExcel("电动自行车");
    }

    /**
     * 京东查询 location=广东，goods_name=关键字，rateDate=20年
     * <p>
     * 按商品=goods_name 聚合
     */
    public void jdCommentExportToExcel(String keyword) throws IOException {
        Query query = Query.query(Criteria.where("created").gte("2020-01-01 00:00:00").lt("2021-01-01 00:00:00")
                .and("goods_type").regex(keyword).and("ship_address").regex("广东"));

        long count = mongoTemplate.count(query, JdComment.class);
        System.out.println(String.format("关键字[%s] 查出 [%s] 条", keyword, count) );
        List<JdComment> items = mongoTemplate.find(query.limit((int) count), JdComment.class);

        Map<String, List<JdComment>> maps = items.stream().collect(Collectors.groupingBy(JdComment::getGoods_name));
        JSONArray jsonArray = new JSONArray();
        maps.forEach((key, value) -> {
            //同一家店铺只取第一条
            JdComment firstJdCommentInGroup = value.get(0);
            firstJdCommentInGroup.setCommentSum(value.size());
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(firstJdCommentInGroup));
            jsonArray.add(jsonObject);
        });
        System.out.println("开始写入excel");
        JsonExcelConvert.json2Excel(jsonArray, "D:\\京东导出数据-"+keyword+".xlsx");
    }

    /**
     * 燃气
     * 文件夹
     * 文件架
     * 订书机
     * 修正笔
     * 修正带
     * 橡皮
     * 修正液
     * 笔
     * 文具
     * 电动自行车
     */
    @Test
    public void jdCommentExportToExcelTest() throws IOException {
        jdCommentExportToExcel("燃气");
        jdCommentExportToExcel("文件夹");
        jdCommentExportToExcel("文件架");
        jdCommentExportToExcel("订书机");
        jdCommentExportToExcel("修正笔");
        jdCommentExportToExcel("修正带");
        jdCommentExportToExcel("橡皮");
        jdCommentExportToExcel("修正液");
        jdCommentExportToExcel("笔");
        jdCommentExportToExcel("文具");
        jdCommentExportToExcel("电动自行车");
    }

}
