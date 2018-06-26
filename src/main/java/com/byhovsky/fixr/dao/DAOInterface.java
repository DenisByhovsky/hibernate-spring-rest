package com.byhovsky.fixr.dao;

import com.byhovsky.fixr.model.Account;

import java.util.List;

public interface DAOInterface<T> {

    Account getById(int id);

    void add(T t);

    void update(T t);

    void remove(int id);

    List<T> getAll();
}
