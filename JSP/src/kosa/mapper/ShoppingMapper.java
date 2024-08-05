package kosa.mapper;

import java.util.List;

import kosa.model.Shopping;

public interface ShoppingMapper {
    // 사용자 ID로 장바구니 조회
    List<Shopping> selectCartByUserId(String id);
    
    // 장바구니에 상품 추가
    int insertProductToCart(Shopping shopping);
}
