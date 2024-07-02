package com.example.Meuble.service;

import com.example.Meuble.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartItemService{
    List<CartItem> getAllCartItems();
    CartItem addToCart(CartItem cartItem);
    CartItem removeFromCart(int id);
    void clearCart ();

}
