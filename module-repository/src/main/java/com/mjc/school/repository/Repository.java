package com.mjc.school.repository;

import java.util.List;

public interface Repository <T> {
List<T> readAll();
T create (T t);
T getNewsById (long id);
T updateNews (T id);
Boolean deleteNewsById (long id);



}
