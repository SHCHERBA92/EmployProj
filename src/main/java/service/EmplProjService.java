package service;

import DAO.EmplProjDAO;
import Entity.EmployeeProject;
import bisnesLog.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {

    Connection connection = super.getConn();

    @Override
    public void addEmployeeProject(EmployeeProject employeeProject) {
        PreparedStatement preparedStatement = null;
        String SQLstr = "INSERT INTO employee_project(id, id_employee, id_project)\n" +
                "values (?,?,?)";

        try {

            preparedStatement = connection.prepareStatement(SQLstr);

            preparedStatement.setLong(1,employeeProject.getId());
            preparedStatement.setLong(2,employeeProject.getIdEmployee());
            preparedStatement.setLong(3,employeeProject.getIdProject());

            preparedStatement.executeUpdate();
            System.out.println("Successfully...");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection failed...");
        }finally {
            if (preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<EmployeeProject> readAllEmployeeProject() {
        List<EmployeeProject> employeeProjectList = new ArrayList<>();
        String SQLstr = "select id, id_employee, id_project from employee_project";
        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLstr);
            while (resultSet.next())
            {
                EmployeeProject project = new EmployeeProject();
                project.setId(resultSet.getLong(1));
                project.setIdEmployee(resultSet.getLong(2));
                project.setIdProject(resultSet.getLong(3));

                employeeProjectList.add(project);
            }

            System.out.println("Successfully...");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection failed...");
        }finally {
            if (statement != null)
            {
                try {
                    statement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        }

        return employeeProjectList;
    }

    @Override
    public EmployeeProject readEmployeeProjectById(Long idEmployee, Long idProject) {
        PreparedStatement preparedStatement = null;
        String SQLstr = "select id, id_employee, id_project from employee_project" +
                " where id_employee = ? AND id_project = ?";
        ResultSet resultSet = null;
        EmployeeProject employeeProject = null;
        try {
            preparedStatement = connection.prepareStatement(SQLstr);
            preparedStatement.setLong(1,idEmployee);
            preparedStatement.setLong(2,idProject);

            resultSet = preparedStatement.executeQuery();

            employeeProject = new EmployeeProject();

            employeeProject.setId(resultSet.getLong(1));
            employeeProject.setIdEmployee(resultSet.getLong(2));
            employeeProject.setIdProject(resultSet.getLong(3));

            System.out.println("Successfully...");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection failed...");
        }finally {
            if (preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }

        return employeeProject;
    }

    @Override
    public void updateEmployeeProject(EmployeeProject employeeProject) {
        String SQLstr = "update employee_project set id = ?, id_employee = ?, id_project = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLstr);

            preparedStatement.setLong(1, employeeProject.getId());
            preparedStatement.setLong(2, employeeProject.getIdEmployee());
            preparedStatement.setLong(3, employeeProject.getIdProject());
            preparedStatement.setLong(1, employeeProject.getId());

            preparedStatement.executeUpdate();

            System.out.println("Successfully...");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection failed...");
        }finally {
            if (preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteEmployeeProject(EmployeeProject employeeProject) {
        String SQLstr = "delete from employee_project where id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQLstr);
            preparedStatement.setLong(1,employeeProject.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            if (preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            if (connection != null)
            {
                try {
                    connection.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }
}
