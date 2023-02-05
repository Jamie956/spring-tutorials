package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class TestService {
    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

    @Test
    public void deleteTest() {
        user1Service.deleteAll();
        user2Service.deleteAll();
    }

    @Test
    public void testUser1Add() {
        user1Service.add();
    }

    @Test
    public void testUser2Add() {
        user2Service.add();
    }

    // 外围方法未开启事务，方法在各自的事务中独立运行，不受外围方法异常影响
    // user1 和 user2都插入成功
    @Test
    public void notransaction_exception_required_required() {
        deleteTest();
        user1Service.add();
        user2Service.add();
        throw new RuntimeException();
    }

    // 外围方法未开启事务，方法在各自的事务中独立运行
    // user1 成功，user2 异常回滚
    @Test
    public void notransaction_required_required_exception() {
        deleteTest();
        user1Service.add();
        user2Service.addWithException();
    }

    // 外围方法开启事务，内部方法加入外部事务，外部方法回滚，内部方法也回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_required(){
        deleteTest();
        user1Service.add();
        user2Service.add();
        throw new RuntimeException();
    }

    // 外围方法开启事务，内部方法加入外部事务，内部方法回滚，外部方法整个事务回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception(){
        deleteTest();
        user1Service.add();
        user2Service.addWithException();
    }

    // 外围方法开启事务，内部方法加入外部事务，即使捕获内部方法异常，外部方法整个事务回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception_try(){
        deleteTest();
        user1Service.add();
        try {
            user2Service.addWithException();
        } catch (Exception e) {
            System.out.println("caught exception.............");
        }
    }

}
