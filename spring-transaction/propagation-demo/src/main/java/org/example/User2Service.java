package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User2Service {
    @Autowired
    private User2Dao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void add() {
        User2 user = new User2();
        user.setName("1");
        userDao.addUser2(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addWithException() {
        User2 user = new User2();
        user.setName("1");
        userDao.addUser2(user);
        throw new RuntimeException();
    }

    public void deleteAll() {
        userDao.deleteAll();
    }
}
