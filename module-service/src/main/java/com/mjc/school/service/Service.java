package com.mjc.school.service;

import java.util.List;

public interface Service<T>{
    List<T> readAll();
    T create (T t);
    T getNewsById (long id);
    T updateNews (T id);
    Boolean deleteNewsById (long id);

}
