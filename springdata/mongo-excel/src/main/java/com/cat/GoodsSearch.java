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
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsSearch {
    @Autowired
    private MongoTemplate mongoTemplate;
    private static final String[] TMALL_HEADERS = {"platform", "goods_name", "title", "keyword", "commentSum", "rateDate", "price",
            "location", "shop_name",  "detail_url", };
    private static final String[] JD_HEADERS = {"platform", "goods_type", "goods_name", "keyword",
            "commentSum", "created", "price", "ship_address", "shop"};

    /**
     * 测试连接用
     */
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
    public JSONArray tmallCommentQueryByKeyword(String keyword, int year) {
        Query query = Query.query(Criteria.where("rateDate").gte(year + "-01-01 00:00:00").lt((year + 1) + "-01-01 00:00:00")
                .and("goods_name").regex(keyword).and("location").regex("广东"));

        long count = mongoTemplate.count(query, TmallComment.class);
        System.out.println(String.format("天猫 关键字[%s] 查出 [%s] 条", keyword, count));
        List<TmallComment> items = mongoTemplate.find(query.limit((int) count), TmallComment.class);

        Map<String, List<TmallComment>> maps = items.stream().collect(Collectors.groupingBy(TmallComment::getTitle));
        JSONArray jsonArray = new JSONArray();
        maps.forEach((key, value) -> {
            //分组内取最新的日期
            List<String> dateList = value.stream().map(TmallComment::getRateDate).sorted().collect(Collectors.toList());
            String newDateInGroup = dateList.get(dateList.size() - 1);
            //同一个商品只取第一条
            TmallComment firstTmallCommentInGroup = value.get(0);

            firstTmallCommentInGroup.setCommentSum(value.size());
            firstTmallCommentInGroup.setKeyword(keyword.replace("[\u4e00-\u9fa5].*", ""));
            firstTmallCommentInGroup.setRateDate(newDateInGroup);
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(firstTmallCommentInGroup));
            jsonArray.add(jsonObject);
        });
        return jsonArray;
    }

    /**
     * 京东查询 location=广东，goods_name=关键字，rateDate=20年
     * <p>
     * 按商品=goods_name 聚合
     */
    public JSONArray jdCommentQueryByKeyword(String keyword, int year) {
        Query query = Query.query(Criteria.where("created").gte(year + "-01-01 00:00:00").lt((year + 1) + "-01-01 00:00:00")
                .and("goods_type").regex(keyword).and("ship_address").regex("广东"));

        long count = mongoTemplate.count(query, JdComment.class);
        System.out.println(String.format("京东 关键字[%s] 查出 [%s] 条", keyword, count));
        List<JdComment> items = mongoTemplate.find(query.limit((int) count), JdComment.class);

        Map<String, List<JdComment>> maps = items.stream().collect(Collectors.groupingBy(JdComment::getGoods_name));
        JSONArray jsonArray = new JSONArray();
        maps.forEach((key, value) -> {
            //分组内取最新的日期
            List<String> dateList = value.stream().map(JdComment::getCreated).sorted().collect(Collectors.toList());
            String newDateInGroup = dateList.get(dateList.size() - 1);
            //同一个商品只取第一条
            JdComment firstJdCommentInGroup = value.get(0);
            firstJdCommentInGroup.setCommentSum(value.size());
            firstJdCommentInGroup.setKeyword(keyword.replace("[\u4e00-\u9fa5].*", ""));
            firstJdCommentInGroup.setCreated(newDateInGroup);
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(firstJdCommentInGroup));
            jsonArray.add(jsonObject);
        });
        return jsonArray;
    }

    public void jdCommentToExcel(String[] keywords, int year) throws IOException {
        JSONArray jdAllData = new JSONArray();
        for (String keyword : keywords) {
            JSONArray jdKeywordData = jdCommentQueryByKeyword(keyword, year);
            jdAllData.addAll(jdKeywordData);
//            System.out.println(String.format("京东 关键字[%s] 开始写入excel", keyword));
//            String fileName = String.format("D:\\京东%s年商品数据-%s.xlsx", year, keyword);
//            JsonExcelConvert.json2Excel(jdKeywordData, fileName, JD_HEADERS);
        }
        System.out.println("京东全部关键字数据 开始写入excel");
        String fileName = String.format("D:\\京东%s年商品数据.xlsx", year);
        JsonExcelConvert.json2Excel(jdAllData, fileName, JD_HEADERS);
    }

    public void tmallCommentToExcel(String[] keywords, int year) throws IOException {
        JSONArray tmallAllData = new JSONArray();
        for (String keyword : keywords) {
            JSONArray tamllKeywordData = tmallCommentQueryByKeyword(keyword, year);
            tmallAllData.addAll(tamllKeywordData);
//            System.out.println(String.format("天猫 关键字[%s] 开始写入excel", keyword));
//            String fileName = String.format("D:\\天猫%s年商品数据-%s.xlsx", year, keyword);
//            JsonExcelConvert.json2Excel(tamllKeywordData, fileName, TMALL_HEADERS);
        }
        System.out.println("天猫全部关键字数据 开始写入excel");
        String fileName = String.format("D:\\天猫%s年商品数据.xlsx", year);
        JsonExcelConvert.json2Excel(tmallAllData, fileName, TMALL_HEADERS);
    }

    @Test
    public void exportTest() throws IOException {
//        String[] keywords = {"燃气","文件夹","文件架","订书机","修正笔","修正带","橡皮","修正液","笔","文具","电动自行车"};
        String[] keywords = {"压力锅","电饭煲","电饭锅","电火锅","电烤箱","电陶炉","电水壶","电热水壶","养生壶","饮水机","电磁炉","微波炉","榨汁机","豆浆机","破壁料理机","破壁机","绞肉机","洗碗机","净水器","净水机","电炊具","电风扇","油烟机","换气扇","排气扇","电[\u4e00-\u9fa5].*热水器","吸顶灯","吊灯","筒灯","壁灯","落地灯","台灯","床单","床罩","被套","棉被","枕头","枕套","毛巾被","厚[\u4e00-\u9fa5].*毯子","空调被","睡袋","儿童服装","童装","婴幼儿服装","婴儿服装","插头","插座","开关","电线电缆","玩具","儿童[\u4e00-\u9fa5].*车","婴儿[\u4e00-\u9fa5].*车","童车","^(?!.*?厚).*毯子.*$"};
        int year = 2020;
        tmallCommentToExcel(keywords, year);
        jdCommentToExcel(keywords, year);
    }

//    @Test
//    public void test1() throws IOException {
//        jdCommentMongoToExcelByKeyword("电动自行车");
//    }
}
