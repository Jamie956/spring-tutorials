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
    public void addRequired() {
        User2 user = new User2();
        user.setName("1");
        userDao.add(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredWithException() {
        User2 user = new User2();
        user.setName("1");
        userDao.add(user);
        throw new RuntimeException();
    }

    public void deleteAll() {
        userDao.deleteAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(){
        User2 user = new User2();
        user.setName("1");
        userDao.add(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNewWithException(){
        User2 user = new User2();
        user.setName("1");
        userDao.add(user);
        throw new RuntimeException();
    }
}
