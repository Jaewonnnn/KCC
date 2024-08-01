package kosa.mapper;

import java.util.List;

import kosa.model.Basket;

public interface BasketMapper {
	void addProduct(Basket basket);
	List<Basket> getProductsByUserId(String userId);
}
