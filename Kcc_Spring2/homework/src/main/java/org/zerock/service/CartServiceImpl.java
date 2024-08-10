package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.CartItem;
import org.zerock.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addToCart(CartItem cart) {
        cartMapper.addToCart(cart);
    }

    @Override
    public List<CartItem> getCartItems(String userId) {
        return cartMapper.getCartItems(userId);
    }
}
