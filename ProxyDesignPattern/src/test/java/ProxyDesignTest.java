import org.example.Employee;
import org.example.EmployeeDao;
import org.example.EmployeeDaoProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyDesignTest {
    private EmployeeDao employeeDao;

    @BeforeEach
    public void setup() {
        employeeDao = new EmployeeDaoProxy();
    }

    @Test
    public void createEmployeeWithAdminAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        try {
            employeeDao.create("ADMIN", new Employee());
        } catch (Exception e) {
            fail("Exception not expected for admin access: " + e.getMessage());
        }
    }

    @Test
    public void createEmployeeWithUserAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        Exception exception = assertThrows(Exception.class, () -> {
            employeeDao.create("USER", new Employee());
        });

        String expectedMessage = "Access Denied";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void deleteEmployeeWithAdminAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        try {
            employeeDao.delete("ADMIN", 1);
        } catch (Exception e) {
            fail("Exception not expected for admin access: " + e.getMessage());
        }
    }

    @Test
    public void deleteEmployeeWithUserAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        Exception exception = assertThrows(Exception.class, () -> {
            employeeDao.delete("USER", 1);
        });

        String expectedMessage = "Access Denied";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getEmployeeWithAdminAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        try {
            employeeDao.get("ADMIN", 1);
        } catch (Exception e) {
            fail("Exception not expected for admin access: " + e.getMessage());
        }
    }

    @Test
    public void getEmployeeWithUserAccess() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        try {
            employeeDao.get("USER", 1);
        } catch (Exception e) {
            fail("Exception not expected for admin access: " + e.getMessage());
        }
    }

    @Test
    public void getEmployeeOtherwise() {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        Exception exception = assertThrows(Exception.class, () -> {
            employeeDao.get("USER1", 1);
        });

        String expectedMessage = "Access Denied";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
