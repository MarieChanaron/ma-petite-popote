package fr.mariech.tp.dao;

import fr.mariech.tp.model.User;

import java.util.List;

public interface GenericDao<T> {

    public Long add(T entity);

    public List<T> fetchAll();

    T fetchElement(T entity);

    public boolean updateElement(T entity);

    public boolean deleteElement(Long id);
}
