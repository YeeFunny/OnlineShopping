package com.repository;

import java.util.List;

import com.dto.CartItem;
import com.dto.User;
import com.exception.DatabaseException;

public interface CartItemRepository {
	
	public CartItem getCartItemById(int cartItemId);
	
	public List<CartItem> getCartItemByUser(User user);

	public int addCartItem(CartItem cartItem) throws DatabaseException;
	
	public int updateCartItem(CartItem cartItem) throws DatabaseException;
	
	public int deleteCartItem(int cartItemId) throws DatabaseException;
}
