package com.example.masterjpa1.services;

import java.util.List;

public interface Service<T> {

    public Long countAll();
    public T findById(Long id);
    public List<T> findAll();
    public T save(T t);
    public T update(T t);
    public void delete(Long id);
}
