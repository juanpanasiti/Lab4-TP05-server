package com.jpanasiti.lab4tp5server.service;

import java.util.List;

public interface IGenericService<E> {
    public E findById(int id) throws Exception;

    public E save(E entityForm) throws Exception;

    public E update(int id, E entityForm) throws Exception;

    public int countPages(int size) throws Exception;

    public List<E> findAll(int page, int size) throws Exception;

    public boolean delete(int id) throws Exception;
}
