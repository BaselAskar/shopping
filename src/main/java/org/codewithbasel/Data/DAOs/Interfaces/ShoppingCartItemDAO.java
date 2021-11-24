package org.codewithbasel.Data.DAOs.Interfaces;

import org.codewithbasel.Model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemDAO extends GenericCURD<ShoppingCartItem> {

    List<ShoppingCartItem> findByCartId(int cartId);
    List<ShoppingCartItem> findByProductId(int productId);
}
