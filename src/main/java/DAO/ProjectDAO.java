package DAO;

import Entity.Employee;
import Entity.Project;

import java.util.List;

public interface ProjectDAO {

    // create
    void addProject(Project project);

    //read
    List<Project> readAllProject();

    //readById
    Project readProjectById(Long id);

    //update
    void updateProject(Project project);

    //delete
    void deleteProject(Long id);
}
