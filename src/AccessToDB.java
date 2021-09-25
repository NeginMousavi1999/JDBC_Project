import organization.Employee;
import organization.Unit;

import java.sql.*;

/**
 * @author Negin Mousavi
 */
public class AccessToDB {
    private Connection connection;

    public AccessToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "123456");
    }

    //1)
    public int addNewEmployee(Employee employee) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO `organization`.`employee` (`first_name`, `last_name`, `personal_id`," +
                            " `birth_date`, `unit_id`) VALUES ('%s', '%s', '%s', '%s', '%o');",
                    employee.getFirstName(), employee.getLastName(), employee.getPersonalId(), employee.getBirthDate(), employee.getUnitId());
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    public int addNewUnit(Unit unit) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO `organization`.`unit` (`name`, `phone_number`) VALUES ('%s', '%s');",
                    unit.getName(), unit.getPhoneNumber());
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }

    //2)
    public boolean isEmployeeExists(int id) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee;");

            while (resultSet.next()) {
                if (resultSet.getInt("id") == id)
                    return true;
            }
        }
        return false;
    }

    public int updateEmployee(int id, String newFirstNAme, String newLastNAme) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("UPDATE employee SET first_name='%s', last_name='%s' WHERE id=%o",
                    newFirstNAme, newLastNAme, id);
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }
    //3)
    public boolean isUnitExists(int id) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM unit;");

            while (resultSet.next()) {
                if (resultSet.getInt("id") == id)
                    return true;
            }
        }
        return false;
    }

    public int updateUnit(int id, String newNAme) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("UPDATE unit SET name='%s' WHERE id=%o",
                    newNAme, id);
            int index = statement.executeUpdate(sqlQuery);
            return index;
        }
        return 0;
    }
    //4)
    //5)
}
