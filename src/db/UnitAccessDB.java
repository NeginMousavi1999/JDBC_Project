package db;

import organization.Unit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Negin Mousavi
 */
public class UnitAccessDB extends AccessToDB {

    public UnitAccessDB() throws ClassNotFoundException, SQLException {
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

    public boolean isUnitExists(int id) throws SQLException {
        if (connection != null) {
            String sql = "SELECT * FROM unit WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
    public void showUnits() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM unit");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + ": " + resultSet.getString("name") + " " + resultSet.getString("phone_number"));
                System.out.println();
            }
        }
    }
}
