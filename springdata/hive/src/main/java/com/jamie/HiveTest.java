package com.jamie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HiveTest {
    @Autowired
    private JdbcTemplate hiveJdbcTemplate;

    @Test
    public void list() {
        String sql="select * from t1";
        List<Map<String, Object>> maps = hiveJdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }
}
