package DAO;

import Entity.EmployeeProject;
import Entity.Project;

import java.util.List;

public interface EmplProjDAO {

    // create
    void addEmployeeProject(EmployeeProject employeeProject);

    //read
    List<EmployeeProject> readAllEmployeeProject();

    //readById
    EmployeeProject readEmployeeProjectById(Long idEmployee, Long idProject);

    //update
    void updateEmployeeProject(EmployeeProject employeeProject);

    //delete
    void deleteEmployeeProject(EmployeeProject employeeProject);
}
