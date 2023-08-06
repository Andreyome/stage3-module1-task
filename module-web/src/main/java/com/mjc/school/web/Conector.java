package com.mjc.school.web;

import java.util.List;

public interface Conector <T> {
    T create (T t);
    T update (T t);
    T read(long id);
    Boolean delete(long id);
    List<T> readAll();

}
