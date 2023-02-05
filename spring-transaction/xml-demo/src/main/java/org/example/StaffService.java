package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add() {
        Staff staff = new Staff();
        staff.setName("1");
        staffDao.add(staff);

        Staff staff2 = new Staff();
        staff2.setName("JDBCTemplate123456789");
        staffDao.add(staff2);
    }
}
