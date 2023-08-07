package com.mjc.school.controller;

import java.util.List;

public interface Controller<T> {
    T create (T t);
    T update (T t);
    T read(long id);
    Boolean delete(long id);
    List<T> readAll();

}