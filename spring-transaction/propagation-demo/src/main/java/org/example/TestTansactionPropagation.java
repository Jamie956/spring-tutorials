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
public class TestTansactionPropagation {
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
        user1Service.addRequired();
    }

    @Test
    public void testUser2Add() {
        user2Service.addRequired();
    }

    // ============================ PROPAGATION_REQUIRED ============================

    // 外部方法未开启事务，方法在各自的事务中独立运行，不受外部方法异常影响
    // user1 和 user2都插入成功
    @Test
    public void noTransactionWithException_required_required() {
        deleteTest();
        user1Service.addRequired();
        user2Service.addRequired();
        throw new RuntimeException();
    }

    // 外部方法未开启事务，方法在各自的事务中独立运行
    // user1 成功，user2 异常回滚
    @Test
    public void noTransaction_required_requiredWithException() {
        deleteTest();
        user1Service.addRequired();
        user2Service.addRequiredWithException();
    }

    // 外部方法开启事务，内部方法都加入外部事务，外部方法异常回滚，内部方法也回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transactionWithException_required_required(){
        deleteTest();
        user1Service.addRequired();
        user2Service.addRequired();
        throw new RuntimeException();
    }

    // 外部方法开启事务，内部方法加入外部事务，内部方法回滚，外部方法整个事务回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiredWithException(){
        deleteTest();
        user1Service.addRequired();
        user2Service.addRequiredWithException();
    }

    // 外部方法开启事务，内部方法加入外部事务，即使外部方法捕获内部方法异常，外部方法整个事务回滚
    // user1 和 user2 异常回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiredWithExceptionCatch(){
        deleteTest();
        user1Service.addRequired();
        try {
            user2Service.addRequiredWithException();
        } catch (Exception e) {
            System.out.println("caught exception.............");
        }
    }

    // ============================ todo check PROPAGATION_REQUIRES_NEW ============================
    // 外部方法没有事务，内部方法在各自内部事务独立运行，内部方法不会回滚
    @Test
    public void noTransactionWithException_requiresNew_requiresNew() {
        deleteTest();
        user1Service.addRequiresNew();
        user2Service.addRequiresNew();
        throw new RuntimeException();
    }

    // user1 成功执行，user2 回滚
    @Test
    public void noTransaction_requiresNew_requiresNewWithException() {
        deleteTest();
        user1Service.addRequiresNew();
        user2Service.addRequiresNewWithException();
    }

    //外部方法开启事务，方法1加入外部方法事务，方法2和3在各自的事务运行，外部事务异常，只有方法1回滚
    //1回滚 2成功 3成功
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transactionWithException_required_requiresNew_requiresNew() {
        deleteTest();
        user1Service.addRequired();
        user2Service.addRequiresNew();
        user2Service.addRequiresNew();
        throw new RuntimeException();
    }

    //外部方法开启事务，方法3异常回滚并往上抛出异常，方法1与外部方法处于事务，所以方法1回滚
    //1回滚 2成功 3回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNewWithException() {
        user1Service.addRequired();
        user2Service.addRequiresNew();
        user2Service.addRequiresNewWithException();
    }

    //外部方法开启事务，方法3在独自事务异常并被外部方法捕获，但是不会被外部方法事务感知
    //1成功 2成功 3回滚
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNewWithExceptionCatch() {
        user1Service.addRequired();
        user2Service.addRequiresNew();
        try {
            user2Service.addRequiresNewWithException();
        } catch (Exception e) {
            System.out.println("回滚");
        }
    }
}
