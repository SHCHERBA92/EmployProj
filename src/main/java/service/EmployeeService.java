package service;

import DAO.EmployeeDAO;
import Entity.AddressEmployee;
import Entity.Employee;
import bisnesLog.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements EmployeeDAO {

   Connection connection = super.getConn();

    @Override
    public void addEmployee(Employee employee) {
        PreparedStatement preparedStatement = null;

        String sqlStr = "INSERT INTO employee(id, firstname, lastname, birthday, address_id)\n" +
                "values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sqlStr);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastNama());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setLong(5,employee.getAddressId());

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
    public List<Employee> readAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        Statement preparedStatement = null;
        String sqlStr = "select id, firstname, lastname, birthday, address_id from employee";

        try {
            preparedStatement =  connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(sqlStr);

            while (resultSet.next())
            {
                Employee employee = new Employee();

                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("firstname"));
                employee.setLastNama(resultSet.getString("lastname"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressId(resultSet.getLong("address_id"));

                employees.add(employee);
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
        return employees;
    }

    @Override
    public Employee readEmployeeById(Long id) {
        Employee employee = null;
        PreparedStatement preparedStatement = null;

        String SQLstr = "select id, firstname, lastname, birthday, adress_id from employee where id = ?";

        try {
            preparedStatement = connection.prepareStatement(SQLstr);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            employee = new Employee();

            employee.setId(id);
            employee.setFirstName(resultSet.getString("firstname"));
            employee.setLastNama(resultSet.getString("lastname"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressId(resultSet.getLong("adress_id"));

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
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String SQLstr = "update employee set firstname = ?, lastname = ?, birthday = ?, adress_id = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLstr);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastNama());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());
            preparedStatement.setLong(5, employee.getId());

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
    public void deleteEmployee(Long id) {
        String SQLstr = "delete from employee where id = ?";
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
