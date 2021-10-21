package com.jamie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void list() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void customSqlTest() {
        List<User> users = userMapper.executeQuery("select * from user");
        users.forEach(System.out::println);

    }

}
