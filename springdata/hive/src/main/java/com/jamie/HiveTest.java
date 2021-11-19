package com.jamie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HiveTest {
    @Autowired
    private JdbcTemplate hiveJdbcTemplate;

    @Test
    public void list() {
        String sql = "select * from t1";
        List<Map<String, Object>> maps = hiveJdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void test1() {
        String sql = "select id, `name` from ods_goods_jd limit 2";
        //重写RowMapper，定义查询结果映射到对象
        List<JdComment> items = hiveJdbcTemplate.query(sql, (ResultSet resultSet, int rowNum) -> {
            JdComment jdComment = new JdComment();
            jdComment.setGoods_id(resultSet.getString("id"));
            jdComment.setComment_id(resultSet.getString("name"));
            return jdComment;
        });
    }

}
