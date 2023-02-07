package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User1Service {
    @Autowired
    private User1Dao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired() {
        User1 user = new User1();
        user.setName("1");
        userDao.add(user);
    }

    public void deleteAll() {
        userDao.deleteAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(){
        User1 user = new User1();
        user.setName("1");
        userDao.add(user);
    }
}
