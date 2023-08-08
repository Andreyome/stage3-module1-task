package com.mjc.school.controller;

import java.util.List;

public interface Controller<T> {
    T create(T t);

    T update(T t);

    T readBy(Long id);

    Boolean delete(Long id);

    List<T> readAll();

}
