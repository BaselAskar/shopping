package org.codewithbasel.Data.DAOs;

import org.codewithbasel.Data.DAOs.Interfaces.ProductDAO;
import org.codewithbasel.Model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {




    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByPriceBetween(double low, double height) {
        return null;
    }
}
