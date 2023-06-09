package fr.mariech.tp.dao;

import fr.mariech.tp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements UserGenericDao {

    Connection connection = ConnectionManager.getInstance();

    @Override
    public long add(User user) {
        return 0;
    }

    @Override
    public List<User> fetchAll() {
        return null;
    }

    @Override
    public User fetchElement(User user) {
        String name = user.getName();
        String password = user.getPassword();
        String query = "SELECT * FROM user WHERE name = ? AND password = ?";
        User userFound = null;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, password);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                userFound = new User(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("password")
                );
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return userFound;
    }

    @Override
    public boolean updateElement(User user) {
        return true;
    }

    @Override
    public boolean deleteElement(long id) {
        return false;
    }
}
