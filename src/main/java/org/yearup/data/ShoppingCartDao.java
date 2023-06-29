package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);

    // add additional method signatures here
    ShoppingCart addProductToCart(int userId);
    ShoppingCart updateCart(int cartId, int productId, int quantity);
    ShoppingCart clearCart(int cartId);
}
