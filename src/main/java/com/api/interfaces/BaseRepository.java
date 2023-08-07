package com.api.interfaces;


import com.api.exceptions.NotFoundBookCustomException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T> {
    List<T> getAll();

    void add(T item);

    List<T> search(String query);

    T getById(int id) throws NotFoundBookCustomException;
}
