package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }
    Product product = new Product();
    @Override
    public ShoppingCart getByUserId(int userId) {
        String sql = "SELECT * FROM shopping_cart WHERE user_id = ?";

        try (Connection connection = getConnection();
        PreparedStatement s = connection.prepareStatement(sql)) {
            s.setInt(1, userId);
            ResultSet resultSet = s.executeQuery();

            if (resultSet.next()) {
                //return mapRow(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ShoppingCart addProductToCart(int userId) {
        return null;
    }

    @Override
    public ShoppingCart updateCart(int cartId, int productId, int quantity) {
        return null;
    }

    @Override
    public ShoppingCart clearCart(int cartId) {
        return null;
    }

    protected static ShoppingCartItem mapRow(ResultSet row) throws SQLException
    {
        int quantity = row.getInt("product_id");
        //Product product = row.getString(product.getName("name"));
        BigDecimal discountPrice = row.getBigDecimal("discountPrice");

        //return new ShoppingCartItem(quantity, product, discountPrice);
        return null;
    }

}
