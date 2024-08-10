package org.zerock.mapper;

import org.zerock.domain.CartItem;
import java.util.List;

public interface CartMapper {
    void addToCart(CartItem cart);
    List<CartItem> getCartItems(String userId);
}
