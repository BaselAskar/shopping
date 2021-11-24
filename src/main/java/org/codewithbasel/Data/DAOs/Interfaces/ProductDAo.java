package org.codewithbasel.Data.DAOs.Interfaces;

import org.codewithbasel.Model.Product;

import java.util.*;

public interface ProductDAo extends GenericCURD<Product> {
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(double low,double height);
}
