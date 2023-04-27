package fr.mariech.tp.dao;

import fr.mariech.tp.model.User;

import java.util.List;

public class UserDao implements GenericDao {

    @Override
    public Long add(Object entity) {
        return null;
    }

    @Override
    public List<User> fetchAll() {
        return null;
    }

    @Override
    public Object fetchElement(int id) {
        return null;
    }

    @Override
    public Object updateElement(Object entity) {
        return null;
    }

    @Override
    public boolean deleteElement(Long id) {
        return false;
    }
}
