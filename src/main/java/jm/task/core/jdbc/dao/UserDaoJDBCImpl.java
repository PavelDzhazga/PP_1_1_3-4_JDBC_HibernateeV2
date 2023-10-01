//package jm.task.core.jdbc.dao;
//import jm.task.core.jdbc.model.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static jm.task.core.jdbc.util.Util.getConnection;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()) {
//            String create = "CREATE TABLE IF NOT EXISTS `pavel`.`user` (\n" +
//                    "  `idUser` INT NOT NULL AUTO_INCREMENT,\n" +
//                    "  `Name` VARCHAR(45) NULL,\n" +
//                    "  `Last_name` VARCHAR(45) NULL,\n" +
//                    "  `age` INT NULL,\n" +
//                    "  PRIMARY KEY (`idUser`),\n" +
//                    "  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE)";
//            statement.executeUpdate(create);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()) {
//            String dropUsers = "DROP TABLE IF EXISTS user";
//            statement.executeUpdate(dropUsers);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String saveUser = "INSERT INTO user(Name, Last_name, age) \n" +
//                " VALUES(?, ?, ?)";
//        try (Connection con = getConnection(); PreparedStatement preStatement = con.prepareStatement(saveUser)) {
//            preStatement.setString(1, name);
//            preStatement.setString(2, lastName);
//            preStatement.setByte(3, age);
//            preStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()) {
//            String remove = "DELETE FROM user WHERE idUser =?";
//            statement.executeUpdate(remove);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        User user = new User();
//
//        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()) {
//
//            String getAll = "SELECT * FROM user";
//            ResultSet resultSet = statement.executeQuery(getAll);
//
//            while (resultSet.next()) {
//                user.setId(resultSet.getLong(1));
//                user.setName(resultSet.getString(2));
//                user.setLastName(resultSet.getString(3));
//                user.setAge(resultSet.getByte(4));
//                userList.add(user);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()) {
//            String clean = "DELETE FROM user";
//            statement.executeUpdate(clean);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
