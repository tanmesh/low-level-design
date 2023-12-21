package org.example;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, Employee emp) throws Exception {
        System.out.println("Created new row in the Employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Deleted row with the employeeId: " + employeeId);
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        System.out.println("Fetching data from DB");
        return new Employee();
    }
}
