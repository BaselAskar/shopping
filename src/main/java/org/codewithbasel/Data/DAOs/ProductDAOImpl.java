package org.codewithbasel.Data.DAOs;

import org.codewithbasel.Data.AbstractDAO;
import org.codewithbasel.Data.DAOs.Interfaces.ProductDAO;
import org.codewithbasel.Model.Product;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO {


    private static List<Product> INSTANCE;

    private List<Product> _products;

    private ProductDAOImpl(List<Product> products){
        _products = products;
    }

    public static ProductDAOImpl getInstance(){
            if (INSTANCE == null){
                INSTANCE = new ArrayList<>();
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try{
                connection = getConnection();
                statement = connection.prepareStatement("SELECT * FROM product");
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    INSTANCE.add(mapProduct(resultSet));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }finally {
                closeAll(connection,statement,resultSet);
            }
        }

            return new ProductDAOImpl(INSTANCE);
    }




    @Override
    public Product save(Product product) {

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            if(product.getId() == 0){
                statement = connection.prepareStatement("INSERT INTO product(name,price) VALUES (?,?);");
                statement.setString(1,product.getName());
                statement.setDouble(2,product.getPrice());
                statement.executeQuery();

            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeAll(connection,statement);
        }


        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
         return  _products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();


    }

    @Override
    public List<Product> findAll() {
        return _products;
    }

    @Override
    public void delete(int id) {
        Product product = findById(id).isPresent() ? findById(id).get() : null;
        if (product != null) _products.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {

        return _products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPriceBetween(double low, double height) {
        return _products.stream()
                .filter(p -> p.getPrice() >= low && p.getPrice() <= height)
                .collect(Collectors.toList());
    }
}
