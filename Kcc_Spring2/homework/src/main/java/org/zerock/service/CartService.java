package org.zerock.service;

import java.util.List;

import org.zerock.domain.CartItem;

public interface CartService {
    void addToCart(CartItem cart);
    List<CartItem> getCartItems(String userId);
}
