package org.codewithbasel.Data;

import org.codewithbasel.Model.Product;
import org.codewithbasel.Model.ShoppingCart;
import org.codewithbasel.Model.ShoppingCartItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AbstractDAO {

    //Close connection method
    public static void closeAll(AutoCloseable...closeables){

        if(closeables != null){

            for (AutoCloseable closeable : closeables) {

                if(closeable != null){

                    try{
                        closeable.close();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }

                }
            }
        }

    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DatabaseCredentials.getInstance().getUrl(),
                DatabaseCredentials.getInstance().getUser(),
                DatabaseCredentials.getInstance().getPassword());
    }

    public ShoppingCart mapShoppingCart(ResultSet resultSet) throws SQLException {
        return new ShoppingCart(
                resultSet.getInt("id"),
                resultSet.getObject("last_update",LocalDateTime.class),
                resultSet.getString("order_status"),
                resultSet.getString("delivery_address"),
                resultSet.getString("customer_reference"),
                resultSet.getBoolean("payment_approved")

        );
    }

    public Product mapProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price")
        );
    }


    public ShoppingCartItem mapShoppingItem(ResultSet resultSet) throws SQLException {
        return new ShoppingCartItem(
                resultSet.getInt("id"),
                resultSet.getInt("amount"),
                resultSet.getDouble("total_price")
        );
    }


}
