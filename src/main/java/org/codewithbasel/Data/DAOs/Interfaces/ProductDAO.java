package org.codewithbasel.Data.DAOs.Interfaces;

import org.codewithbasel.Model.Product;

import java.util.*;

public interface ProductDAO extends GenericCURD<Product> {
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(double low,double height);
}
