package service;

import DAO.ProjectDAO;
import Entity.AddressEmployee;
import Entity.Project;
import bisnesLog.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectSrvice extends Util implements ProjectDAO {

    Connection connection = super.getConn();

    @Override
    public void addProject(Project project) {
        PreparedStatement preparedStatement = null;

        String sqlStr = "INSERT INTO project(id, title, grade)\n" +
                "values (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sqlStr);

            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());
            preparedStatement.setInt(3,project.getGrade());
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
    public List<Project> readAllProject() {
        List<Project> projects = new ArrayList<>();
        Statement preparedStatement = null;
        String sqlStr = "select id, title, grade from project";

        try {
            preparedStatement =  connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(sqlStr);

            while (resultSet.next())
            {
                Project project = new Project();

                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));
                project.setGrade(resultSet.getInt("grade"));

                projects.add(project);
            }
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
        return projects;
    }

    @Override
    public Project readProjectById(Long id) {
        String strSQL = "select id, title, grade from project where id = ?";
        PreparedStatement preparedStatement = null;
        Project project = null;

        try {
            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            project = new Project();

            project.setId(id);
            project.setTitle(resultSet.getString("title"));
            project.setGrade(resultSet.getInt("grade"));

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Connection failed...");
        }finally {
            if (preparedStatement!=null)
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
        return project;
    }

    @Override
    public void updateProject(Project project) {
        String SQLstr = "update project set id = ?, title = ?, grade = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLstr);

            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
            preparedStatement.setInt(3, project.getGrade());
            preparedStatement.setLong(4, project.getId());

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

    @Override
    public void deleteProject(Long id) {
        String SQLstr = "delete from project where id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQLstr);
            preparedStatement.setLong(1,id);
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
