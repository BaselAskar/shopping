package org.codewithbasel.Data.DAOs.Interfaces;

import org.codewithbasel.Model.ShoppingCart;

import java.util.List;

public interface ShoppingCartDAO extends GenericCURD<ShoppingCart>{

    List<ShoppingCart> findByOrderStatus(String status);
    List<ShoppingCart> findByReference(String customer);

}
