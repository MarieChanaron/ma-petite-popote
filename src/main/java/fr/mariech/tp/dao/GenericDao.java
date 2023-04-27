package fr.mariech.tp.dao;

import java.util.List;

public interface GenericDao<T> {

    public Long add(T entity);

    public List<T> fetchAll();

    public T fetchElement(int id);

    public T updateElement(T entity);

    public boolean deleteElement(Long id);
}
