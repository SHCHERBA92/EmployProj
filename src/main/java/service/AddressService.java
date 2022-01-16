package service;

import DAO.AddressDAO;
import Entity.AddressEmployee;
import bisnesLog.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressService extends Util implements AddressDAO {

    private static Long count = 10l;

    Connection connection = super.getConn();

    @Override
    public void add(AddressEmployee address) {
        PreparedStatement preparedStatement = null;

        String sqlStr = "INSERT INTO address(id, city, street, numberhouse, numberapartment)\n" +
                "values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sqlStr);

            preparedStatement.setLong(1,address.getId());
            preparedStatement.setString(2,address.getCity());
            preparedStatement.setString(3,address.getStreet());
            preparedStatement.setString(4, address.getNumberOfHouse());
            preparedStatement.setInt(5,address.getNumberOfApartment());

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

    public void add() {
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id : \t");
        Long id = scanner.nextLong();
        System.out.print("Введите город : \t");
        String city = scanner.nextLine();
        System.out.print("Введите улицу : \t");
        String street = scanner.nextLine();
        System.out.print("Введите номер дома : \t");
        String numberHouse = scanner.nextLine();
        System.out.print("Введите номер квартиры : \t");
        Integer numberApartment = scanner.nextInt();

        String sqlStr = "INSERT INTO address(id, city, street, numberhouse, numberapartment)\n" +
                "values (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sqlStr);

            preparedStatement.setLong(1,id);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,street);
            preparedStatement.setString(4,numberHouse);
            preparedStatement.setInt(5,numberApartment);

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
    public List<AddressEmployee> getAll() {

        List<AddressEmployee> addressEmployees = new ArrayList<>();
        Statement preparedStatement = null;
        String sqlStr = "select id, city, street, numberhouse, numberapartment from address";

        try {
            preparedStatement =  connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(sqlStr);

            while (resultSet.next())
            {
                AddressEmployee addressEmployee = new AddressEmployee();
                addressEmployee.setId(resultSet.getLong("id"));
                addressEmployee.setCity(resultSet.getString("city"));
                addressEmployee.setStreet(resultSet.getString("street"));
                addressEmployee.setNumberOfHouse(resultSet.getString("numberhouse"));
                addressEmployee.setNumberOfApartment(resultSet.getInt("numberapartment"));

                addressEmployees.add(addressEmployee);
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
        return addressEmployees;
    }

    @Override
    public AddressEmployee getAddressById(Long id) {
        String strSQL = "select id, city, street, numberhouse, numberapartment from address where id = ?";
        PreparedStatement preparedStatement = null;
        AddressEmployee addressEmployee = null;
        try {
            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            addressEmployee = new AddressEmployee();

            addressEmployee.setId(id);
            addressEmployee.setCity(resultSet.getString("city"));
            addressEmployee.setStreet(resultSet.getString("street"));
            addressEmployee.setNumberOfHouse(resultSet.getString("numberhouse"));
            addressEmployee.setNumberOfApartment(resultSet.getInt("numberapartment"));


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

        return addressEmployee;
    }

    public AddressEmployee getAddressById() {
        String strSQL = "select id, city, street, numberhouse, numberapartment from address where id = ?";
        PreparedStatement preparedStatement = null;
        AddressEmployee addressEmployee = null;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите логин address");
            Long id = scanner.nextLong();

            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            addressEmployee = new AddressEmployee();

            addressEmployee.setId(id);
            addressEmployee.setCity(resultSet.getString("city"));
            addressEmployee.setStreet(resultSet.getString("street"));
            addressEmployee.setNumberOfHouse(resultSet.getString("numberhouse"));
            addressEmployee.setNumberOfApartment(resultSet.getInt("numberapartment"));


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

        return addressEmployee;
    }

    @Override
    public void update(AddressEmployee addressEmployee) {
        String SQLstr = "update address set city = ?, street = ?, numberhouse = ?, numberapartment = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLstr);

            preparedStatement.setString(1, addressEmployee.getCity());
            preparedStatement.setString(2, addressEmployee.getStreet());
            preparedStatement.setString(3, addressEmployee.getNumberOfHouse());
            preparedStatement.setInt(4, addressEmployee.getNumberOfApartment());
            preparedStatement.setLong(5, addressEmployee.getId());

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
    public void remove(Long id) {
       String SQLstr = "delete from address where id = ?";
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
