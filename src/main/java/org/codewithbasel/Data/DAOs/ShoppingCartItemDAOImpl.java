package org.codewithbasel.Data.DAOs;

import org.codewithbasel.Data.DAOs.Interfaces.ShoppingCartItemDAO;
import org.codewithbasel.Model.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {





    @Override
    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        return null;
    }

    @Override
    public Optional<ShoppingCartItem> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ShoppingCartItem> findByCartId(int cartId) {
        return null;
    }

    @Override
    public List<ShoppingCartItem> findByProductId(int productId) {
        return null;
    }
}
