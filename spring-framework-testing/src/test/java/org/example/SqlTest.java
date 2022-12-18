package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Sql({"drop_schema.sql", "create_schema.sql"})
@Sql(scripts = "insert_data1.sql", statements = "insert into student(id, name) values (100, 'Shiva')")
@SpringJUnitConfig
public class SqlTest {

    @Configuration
    static class MyConfig {
        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setName("test-db").build();
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * FROM student");
        Assert.assertEquals(3, students.size());
    }

}
