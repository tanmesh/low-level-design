package org.example;

public interface EmployeeDao {
    public void create(String client, Employee emp) throws Exception;

    public void delete(String client, int employeeId) throws Exception;

    public Employee get(String client, int employeeId) throws Exception;
}
