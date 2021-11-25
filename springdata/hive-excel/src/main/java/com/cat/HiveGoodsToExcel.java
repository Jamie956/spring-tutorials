package com.cat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HiveGoodsToExcel {
    @Autowired
    private JdbcTemplate hiveJdbcTemplate;
    private static final String[] TMALL_HEADERS = {"platform", "goods_name", "title", "keyword", "commentSum", "rateDate", "price",
            "location", "shop_name", "detail_url",};
    private static final String[] JD_HEADERS = {"platform", "goods_type", "goods_name", "keyword",
            "commentSum", "created", "price", "ship_address", "shop"};

    public JSONArray queryByKeyword(String[] keywords, int year) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < keywords.length; i++) {
            stringBuilder.append("t1.goods_type like '%").append(keywords[i]).append("%'");
            if (i != keywords.length - 1) {
                stringBuilder.append(" or ");
            }
        }
        String keywordsCondition = stringBuilder.toString();

        String sql = "select\n" +
                "'京东' as platform,\n" +
                "t1.goods_type as goods_type,\n" +
                "t1.title as goods_name,\n" +
                "t4.cnt as commentSum,\n" +
                "t1.update_time as created,\n" +
                "t1.pc_price as price,\n" +
                "t1.ship_address as ship_address,\n" +
                "t1.shop as shop\n" +
                "from ods_goods_jd t1\n" +
                "inner join (\n" +
                "  select c.goods_id as goods_id, count(*) as cnt from ods_comments_jd c where c.created like '" + year + "%' group by c.goods_id\n" +
                ")t4 on t1.goods_id=t4.goods_id\n" +
                "where\n" +
                "(" + keywordsCondition + ") and\n" +
                "t1.ship_address like '%广东%' limit 100";
        System.out.println("hive sql -> "+ sql);
        List<JdComment> list = this.hiveJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JdComment.class));
        System.out.println(String.format("京东hive查询 [%s]条", list.size()));

        fullFillJdKeyword(list, keywords);

        String jsonArrayStr = JSON.toJSONString(list);
        return JSON.parseArray(jsonArrayStr);
    }

    /**
     * 京东商品类型与全部关键字对比，如果京东商品类型包含关键字，将关键字存到评论对象
     */
    public void fullFillJdKeyword(List<JdComment> list, String[] keywords) {
        for (JdComment jdComment : list) {
            String goodsType = jdComment.getGoods_type();
            StringBuilder stringBuilder = new StringBuilder();
            for (String keyword : keywords) {
                if (goodsType.contains(keyword)) {
                    stringBuilder.append(keyword).append("、");
                }
            }
            String keywordStr = stringBuilder.toString();
            String subKeywordStr = keywordStr.substring(0, keywordStr.length() - 1);
            jdComment.setKeyword(subKeywordStr);
        }
    }

    public void jdCommentToExcel(String[] keywords, int year) throws IOException {
        JSONArray jdAllData = queryByKeyword(keywords, year);

        System.out.println("京东hive全部关键字数据 开始写入excel");
        String fileName = String.format("D:\\京东%s年hive商品评论数据.xlsx", year);
        JsonExcelConvert.json2Excel(jdAllData, fileName, JD_HEADERS);
    }

    @Test
    public void export() throws IOException {
        String[] keywords = {"压力锅", "电饭煲", "电饭锅", "电火锅", "电烤箱", "电陶炉", "电水壶", "电热水壶", "养生壶", "饮水机", "电磁炉", "微波炉", "榨汁机", "豆浆机", "破壁料理机", "破壁机", "绞肉机", "洗碗机", "净水器", "净水机", "电炊具", "电风扇", "油烟机", "换气扇", "排气扇", "电%热水器", "吸顶灯", "吊灯", "筒灯", "壁灯", "落地灯", "台灯", "床单", "床罩", "被套", "棉被", "枕头", "枕套", "毛巾被", "厚%毯子", "空调被", "睡袋", "儿童服装", "童装", "婴幼儿服装", "婴儿服装", "插头", "插座", "开关", "电线电缆", "玩具", "儿童%车", "婴儿%车", "童车"};

//        jdCommentToExcel(keywords, 2020);
        jdCommentToExcel(keywords, 2021);
    }

}
