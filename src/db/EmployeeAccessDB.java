package db;

import organization.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Negin Mousavi
 */
public class EmployeeAccessDB extends AccessToDB {

    public EmployeeAccessDB() throws ClassNotFoundException, SQLException {
    }

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

    public boolean isEmployeeExists(int id) throws SQLException {
        if (connection != null) {
            String sql = "SELECT * FROM employee WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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

    public void showEmployeesInSpecificUnit(int unitId) throws SQLException {
        int countToShow = 0;
        if (connection != null) {
            String sql = "SELECT * FROM employee WHERE unit_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, unitId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + ": " + resultSet.getString("first_name") +
                        " " + resultSet.getString("last_name"));
                System.out.println();
                countToShow++;
            }
        }
        if (countToShow == 0)
            System.out.println("there is no employee for this unit !!!");
    }
}
