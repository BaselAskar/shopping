package org.codewithbasel.Data.DAOs.Interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericCURD<T>{
    T save(T t);
    Optional<T> findById(int id);
    List<T> findAll();
    void delete(int id);

}
