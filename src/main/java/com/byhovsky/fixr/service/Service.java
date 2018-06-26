package com.byhovsky.fixr.service;

import java.util.List;

public interface Service<T> {

    T getById(int id);

    void add(T t);

    void update(T t);

    void remove(int id);

    List<T> getAll();
}
