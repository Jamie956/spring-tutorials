package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOUnitTest {
//    @Mock
//    JdbcTemplate jdbcTemplate;

    DataSource dataSource;

    @Before
    public void setup() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

    @Test
    public void testCount() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setDataSource(dataSource);
        assertEquals(4, employeeDAO.count());
    }

    @Test
    public void testFindAll() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setDataSource(dataSource);

        List<Employee> employees = employeeDAO.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        assertEquals(4, employees.size());
    }
}
