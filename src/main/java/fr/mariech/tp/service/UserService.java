package fr.mariech.tp.service;

import fr.mariech.tp.dao.UserDao;
import fr.mariech.tp.model.User;

public class UserService {

    UserDao userDao = new UserDao();

    public boolean getUser(String name, String password) {
        User user = new User(name, password);
        return userDao.updateElement(user);
    }
}
