package org.codewithbasel.Data.DAOs;

import org.codewithbasel.Data.DAOs.Interfaces.ShoppingCartDAO;
import org.codewithbasel.Model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public class ShoppingDAOImpl implements ShoppingCartDAO {
    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public Optional<ShoppingCart> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ShoppingCart> findByOrderStatus(String status) {
        return null;
    }

    @Override
    public List<ShoppingCart> findByReference(String customer) {
        return null;
    }
}
