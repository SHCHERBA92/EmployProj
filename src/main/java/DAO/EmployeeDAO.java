package DAO;

import Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // create
    void addEmployee(Employee employee);

    //read
    List<Employee> readAllEmployee();

    //readById
    Employee readEmployeeById(Long id);

    //update
    void updateEmployee(Employee employee);

    //delete
    void deleteEmployee(Long id);
}
